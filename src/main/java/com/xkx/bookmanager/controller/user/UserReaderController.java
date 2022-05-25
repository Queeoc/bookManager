package com.xkx.bookmanager.controller.user;

import com.xkx.bookmanager.mapper.*;
import com.xkx.bookmanager.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.lang.System;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Controller
@RequestMapping("/user")
public class UserReaderController {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private ReserveMapper reserveMapper;

    @Autowired
    private FineMapper fineMapper;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/index")
    private String index(HttpSession session, Model model){
        System.out.println("1111111111111");
        String username = (String)session.getAttribute("username");
        int borrowedBooks = recordMapper.getOwnRecord(username).size();
        int returnBooks = recordMapper.getTotalReturnedBooksById(username);
        int sumFine = 0;
        int paidFine=0;
        int reserveSuccess = 0;
        int reserveFail = 0;
        List<Book> rec = new ArrayList<>();

        Date date = new Date();
        long date1 = date.getTime();
        List<Record> records = recordMapper.getNotifyBooksIdByReaderId(username);

        Iterator<Record> it1 = records.iterator();
        while(it1.hasNext()){
            Record r1 = it1.next();
            rec.add(bookMapper.getBookById(r1.getBookId()));
        }

        List<Fine>fine = fineMapper.getFineById(username);
        Iterator<Fine> fineIt = fine.iterator();
        while(fineIt.hasNext()){
            Fine f = fineIt.next();
            paidFine+=Integer.parseInt(f.getFineCount());
        }

        List<Record> record = recordMapper.getOwnRecord(username);
        Iterator<Record> it = record.iterator();
        while (it.hasNext()){
            Record r = (Record) it.next();
            long date2 = r.getLatestFineDay().getTime();
            if (date1 - date2 > 0) {
                sumFine += (int) ((date1 - date2) / (1000 * 3600 * 24));
            }
        }
        List<Reserve> reserves = reserveMapper.getReserveBooksByReaderId(username);
        Iterator<Reserve> iterator = reserves.iterator();
        while(iterator.hasNext()){
            Reserve next = iterator.next();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                long date3 = simpleDateFormat.parse(next.getReserveTime()).getTime();
                if(date1 - date3 > (1000 * 3600 * 4)){
                    reserveFail++;
                }else{
                    reserveSuccess++;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        int reserveTotal = reserveFail + reserveSuccess;
        recordMapper.setBookStateByReaderId(username);


        model.addAttribute("borrowedBooks",borrowedBooks);
        model.addAttribute("returnBooks",returnBooks);
        model.addAttribute("sumFine",sumFine);
        model.addAttribute("paidFine",paidFine);
        model.addAttribute("reserveSuccess",reserveSuccess);
        model.addAttribute("reserveFail",reserveFail);
        model.addAttribute("records",rec);
        model.addAttribute("reserveTotal",reserveTotal);


//        System.out.println(borrowedBooks);
//        System.out.println(returnBooks);
//        System.out.println(sumFine);
//        System.out.println(reserveFail);
//        System.out.println(reserveSuccess);


        return "user/index";
    }

    @RequestMapping("/toInfoPage")
    public String toInfoPage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        Reader info = readerMapper.getReaderInfoByReaderId(username);
        model.addAttribute("info", info);
        return "user/reader_info";
    }

    @RequestMapping("/info/update")
    public String update(Reader reader) {
        readerMapper.updateInfo(reader);
        return "redirect:/user/toInfoPage";
    }
}
