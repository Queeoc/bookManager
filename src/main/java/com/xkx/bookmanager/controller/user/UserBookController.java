package com.xkx.bookmanager.controller.user;

import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.mapper.ReaderMapper;
import com.xkx.bookmanager.mapper.RecordMapper;
import com.xkx.bookmanager.pojo.Book;
import com.xkx.bookmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/book")
public class UserBookController {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/getAll")
    public String getAll(HttpSession session, Model model) {
        List<Book> books = bookMapper.getAllBook();
        int recordNum=recordMapper.getRecordNum((String) session.getAttribute("username"));
        model.addAttribute("recording",recordNum);
        model.addAttribute("books", books);
        return "user/books";
    }

    @RequestMapping("/info/{id}")
    public String info(Model model, @PathVariable("id") String id) {
        List<Book> books = bookMapper.getBookByIsbn(id);
        model.addAttribute("books", books);
        return "user/book_info";
    }

    @RequestMapping("/search")
    public String search(String keyword, Model model) {
        List<Book> books = bookMapper.searchBook(keyword);
        model.addAttribute("books", books);
        return "user/book_search_result";
    }

    @RequestMapping("/borrow/{id}")
    public String borrow(HttpSession session, Model model, @PathVariable("id") String id){
        bookMapper.borrowBookById(id);
        String username = (String) session.getAttribute("username");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Calendar nowTime = Calendar.getInstance();
        Calendar returnTime = Calendar.getInstance();
        returnTime.add(Calendar.DATE,10);
        Date nowtime = nowTime.getTime();
        Date returntime = returnTime.getTime();

        Record r=new Record(id,username,nowtime,returntime);
        recordMapper.insertRecord(r);
        List<Book> books = bookMapper.getAllBook();
        model.addAttribute("books",books);
        return "redirect:/user/book/getAll";
    }
}
