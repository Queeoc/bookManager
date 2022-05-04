package com.xkx.bookmanager.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.pojo.Book;
import com.xkx.bookmanager.util.barCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Book> books = bookMapper.getAllBook();
        model.addAttribute("books", books);

        return "admin/books";
    }

    @RequestMapping("/info/{isbn}")
    public String info(Model model, @PathVariable("isbn") String isbn) {
        List<Book> books = bookMapper.getBookByIsbn(isbn);
        model.addAttribute("books", books);
        return "admin/book_info";
    }

    @RequestMapping("/toEditPage/{id}")
    public String toEditPage(Model model, @PathVariable("id") String id) {
        Book book = bookMapper.getBookById(id);
        model.addAttribute("book", book);
        return "admin/book_edit";
    }

    @RequestMapping("/EditPage/{id}")
    public String EditPage(Model model, @PathVariable("id") String id) {
        Book book = bookMapper.getBookById(id);
        model.addAttribute("book", book);
        return "admin/book_editBasic";
    }

    @RequestMapping("/update")
    public String update(Book book) {
        bookMapper.updateBook(book);
        return "redirect:/admin/book/getAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        bookMapper.deleteBook(id);
        return "redirect:/admin/book/getAll";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "admin/book_add";
    }

    @RequestMapping("/toAddPageWithISBN")
    public String toAddPageWithISBN() {
        return "admin/book_getISBN";
    }

    @RequestMapping("/getByISBN")
    public String getByISBN(Model model,String ISBN_num){
        Book book=new Book();
        String Publishing,Name,Author,Price,Description;

        String Publish_time;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        try {
            String result = HttpRequest.get("https://api.jike.xyz/situ/book/isbn/"+ISBN_num+"?apikey=12573.1b848ff5b812e81c6dbce3537e987b54.03e707fe58717f5941a88adec803e40a").body();
            //String result = HttpRequest.get("https://www.baidu.com").body();

            //将返回字符串转换为JSON对象

            JSONObject json = JSONObject.parseObject(result);


            Name = (String) json.getJSONObject("data").get("name");
            Author = (String) json.getJSONObject("data").get("author");
            Publish_time = (String) json.getJSONObject("data").get("published");
            Publishing = (String) json.getJSONObject("data").get("publishing");
            Description = (String) json.getJSONObject("data").get("description");
            Price = (String) json.getJSONObject("data").get("price");

            //统一日期格式
            if(Publish_time.length() < 7 && Publish_time.indexOf(5) != '0'){
                Publish_time = new StringBuilder(Publish_time).insert(5,'0').toString();
            }

            if(Publish_time.length() == 7){
                Publish_time = Publish_time + "-01";
            }
            if(Publish_time.length() <10){
                Publish_time = new StringBuilder(Publish_time).insert(8,'0').toString();
            }
            if(Publish_time.length() >10){
                Publish_time = Publish_time.substring(0,10);
            }

//            Date parse = sf.parse(Publish_time);


            book.setBookName(Name);
            book.setAuthor(Author);
            book.setIsbn(ISBN_num);
            book.setPublishTime(Publish_time);
            book.setDescription(Description);
            book.setPublisher(Publishing);
            book.setPrice(Price);


            model.addAttribute("book",book);

            return "admin/book_add_with_ISBN";

        } catch (Exception e) {
            return "redirect:/admin/book/getAll";
        }

    }


    @RequestMapping("/add")
    public String add(Model model , Book book, @ModelAttribute(value="number") String number) throws ParseException {
        int n=Integer.parseInt(number);

//        Random random = new Random(10);
//        int j = random.nextInt(10);
//        int k = random.nextInt(10);
//        int l = random.nextInt(10);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        for (int i=0;i<n;i++) {
            book.setState(1);

//            System.out.println("success!!");
            bookMapper.addBook(book);

//            System.out.println("success!!!!!!!!!!!!!!");
        }
        for (Book book1 : bookMapper.getBookByIsbn(book.getIsbn())) {
            book1.setBookBarcode("/"+book1.getBookId()+".jpg");
            bookMapper.updateBookBarcodeByIsbn(book1);

        }
        List<Book> books = bookMapper.getBookByIsbn(book.getIsbn());
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(Integer.parseInt(o1.getBookId()) < Integer.parseInt(o2.getBookId()))
                return -1;

                return 0;
            }
        });
        List<Book> booksSub = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            booksSub.add(books.get(i));
        }

        model.addAttribute("books",booksSub);
        return "admin/book_add_success";
    }

    @RequestMapping("/search")
    public String search(String keyword, Model model) {
        List<Book> books = bookMapper.searchBook(keyword);
        model.addAttribute("books", books);
        return "admin/book_search_result";
    }

    @RequestMapping("/updatebasic")
    public String updateBasic(Book book) {
        bookMapper.updateBookBasic(book);
        return "redirect:/admin/book/getAll";
    }
}
