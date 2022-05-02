package com.xkx.bookmanager.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Book> books = bookMapper.getAllBook();
        model.addAttribute("books", books);

        System.out.println(books.get(0));
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
        String Publish_time,Publishing,Name,Author,Price,Description;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        try {
            String result = HttpRequest.get("https://api.jike.xyz/situ/book/isbn/"+ISBN_num+"?apikey=12458.27f8ef2c1fdf5d0a0ebb19642b3ec9c7.a13bf079099ad1c733d1b598caf82f91").body();
            //String result = HttpRequest.get("https://www.baidu.com").body();

            //将返回字符串转换为JSON对象

            JSONObject json = JSONObject.parseObject(result);


            Name = (String) json.getJSONObject("data").get("name");
            Author = (String) json.getJSONObject("data").get("author");
            Publish_time = (String) json.getJSONObject("data").get("published");
            Publishing = (String) json.getJSONObject("data").get("publishing");
            Description = (String) json.getJSONObject("data").get("description");
            Price = (String) json.getJSONObject("data").get("price");



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
            JOptionPane.showMessageDialog(null, "网络连接失败 或 未找到");
            return "redirect:/admin/book/getAll";
        }

    }


    @RequestMapping("/add")
    public String add(Book book, @ModelAttribute(value="number") String number) {
        int n=Integer.parseInt(number);
        for (int i=0;i<n;i++) {
            book.setState(1);
            bookMapper.addBook(book);
        }
        return "redirect:/admin/book/getAll";
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
