package com.xkx.bookmanager.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.mapper.ParamMapper;
import com.xkx.bookmanager.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin/book")
public class AdminBookController {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ParamMapper paramMapper;

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

    @RequestMapping("/lost/{id}")
    public String lost(@PathVariable("id") String id) {
        bookMapper.lostBook(id);
        return "redirect:/admin/book/getAll";
    }

    @RequestMapping("/damage/{id}")
    public String damage(@PathVariable("id") String id) {
        bookMapper.damageBook(id);
        return "redirect:/admin/book/getAll";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage(Model model) {
        List<String> categories = paramMapper.getAllCategories();

        model.addAttribute("categories", categories);
        for (String cate : categories) {
            System.out.println(cate);
        }
        model.addAttribute("face", paramMapper.getFace());
        model.addAttribute("column", paramMapper.getColumn());
        model.addAttribute("floor", paramMapper.getFloor());
        model.addAttribute("row", paramMapper.getRow());
        return "admin/book_add";
    }

    @RequestMapping("/toAddPageWithISBN")
    public String toAddPageWithISBN(Model model) {

        return "admin/book_getISBN";
    }

    @RequestMapping("/getByISBN")
    public String getByISBN(Model model, String ISBN_num) {
        Book book = new Book();
        String Publish_time, Publishing, Name, Author, Price, Description, PictureUrl;
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
        try {
            String result = HttpRequest.get("https://api.jike.xyz/situ/book/isbn/" + ISBN_num + "?apikey=12458.27f8ef2c1fdf5d0a0ebb19642b3ec9c7.a13bf079099ad1c733d1b598caf82f91").body();
            //String result = HttpRequest.get("https://www.baidu.com").body();

            //???????????????????????????JSON??????

            JSONObject json = JSONObject.parseObject(result);


            Name = (String) json.getJSONObject("data").get("name");
            Author = (String) json.getJSONObject("data").get("author");
            Publish_time = (String) json.getJSONObject("data").get("published");
            Publishing = (String) json.getJSONObject("data").get("publishing");
            Description = (String) json.getJSONObject("data").get("description");
            Price = (String) json.getJSONObject("data").get("price");
            System.out.println("Price= " + Price);
            PictureUrl = (String) json.getJSONObject("data").get("photoUrl");
            System.out.println("PictureUrl = " + PictureUrl);

            //??????????????????
            if (Publish_time.length() == 0) {
                Publish_time = "1990-03-01";
            }
            if (Publish_time.length() < 7 && Publish_time.indexOf(5) != '0') {
                Publish_time = new StringBuilder(Publish_time).insert(5, '0').toString();
            }

            if (Publish_time.length() == 7) {
                Publish_time = Publish_time + "-01";
            }
            if (Publish_time.length() < 10) {
                Publish_time = new StringBuilder(Publish_time).insert(8, '0').toString();
            }
            if (Publish_time.length() > 10) {
                Publish_time = Publish_time.substring(0, 10);
            }

            if (PictureUrl.length() == 0) {
                PictureUrl = "/picture.jpg";
            }

            book.setPicture(PictureUrl);
            book.setBookName(Name);
            book.setAuthor(Author);
            book.setIsbn(ISBN_num);
            book.setPublishTime(Publish_time);
            book.setDescription(Description);
            book.setPublisher(Publishing);
            book.setPrice(Price);

            model.addAttribute("book", book);
            List<String> categories = paramMapper.getAllCategories();

            model.addAttribute("categories", categories);
            for (String cate : categories) {
                System.out.println(cate);
            }
            model.addAttribute("face", paramMapper.getFace());
            model.addAttribute("column", paramMapper.getColumn());
            model.addAttribute("floor", paramMapper.getFloor());
            model.addAttribute("row", paramMapper.getRow());


            return "admin/book_add_with_ISBN";

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "?????????????????? ??? ?????????");
            return "redirect:/admin/book/getAll";
        }

    }


    @RequestMapping("/add")
    public String add(Model model, Book book, @ModelAttribute(value = "number") String number) {
        int n = Integer.parseInt(number);
        for (int i = 0; i < n; i++) {
            book.setState(1);
            bookMapper.addBook(book);
        }
        for (Book book1 : bookMapper.getBookByIsbn(book.getIsbn())) {
            book1.setBookBarcode("/" + book1.getBookId() + ".jpg");
            bookMapper.updateBookBarcodeByIsbn(book1);
        }
        List<Book> books = bookMapper.getBookByIsbn(book.getIsbn());
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (Integer.parseInt(o1.getBookId()) > Integer.parseInt(o2.getBookId()))
                    return -1;

                return 0;
            }
        });
        List<Book> booksSub = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            booksSub.add(books.get(i));
        }

        model.addAttribute("books", booksSub);
        return "admin/book_add_success";
//        return "redirect:/admin/book/getAll";
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

    @RequestMapping("/searchByLocation")
    public String searchByLocation(Model model, String face, String column, String floor, String row) {
        List<Book> books = bookMapper.searchBookByLocation(floor, face, column, row);

        model.addAttribute("books", books);
        return "admin/book_search_result";
    }

    @RequestMapping("/searchByCategory/{ca}")
    public String searchByCategory(Model model, @PathVariable("ca") String ca) {
//        List<Book> books = bookMapper.searchBookByLocation(floor,face,column,row);
        List<Book> books = bookMapper.searchBookByCategory(ca);
        model.addAttribute("books", books);
        return "admin/book_search_result";
    }
}
