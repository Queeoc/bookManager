package com.xkx.bookmanager.controller.admin;

import com.xkx.bookmanager.mapper.*;
import com.xkx.bookmanager.pojo.Reader;
import com.xkx.bookmanager.pojo.Record;
import com.xkx.bookmanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminIndexController {


    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FineMapper fineMapper;

    @RequestMapping("/index")
    public String index(Model model){

        int totalReaderCounts = userMapper.getTotalReaderCounts();
        int totalBookCounts = bookMapper.getTotalBookCounts();
        int totalBookCopies = bookMapper.getTotalBookCopies();
        int totalBorrows = recordMapper.getTotalBorrows();
        int totalFines = fineMapper.getTotalFines();
        int totalLostBooks = bookMapper.getTotalLostBooks();
        int totalDamagedBooks = bookMapper.getTotalDamagedBooks();
        int totalUnpaidFines = 0;
        Date date = new Date();
        long date1 = date.getTime();
        List<Record> record = recordMapper.getAllRecord();
        Iterator<Record> it = record.iterator();
        while (it.hasNext()){
            Record r = (Record) it.next();
            long date2 = r.getLatestFineDay().getTime();
            if (date1 - date2 > 0) {
                totalUnpaidFines += (int) ((date1 - date2) / (1000 * 3600 * 24));
            }
        }


        model.addAttribute("totalReaderCounts",totalReaderCounts);
        model.addAttribute("totalBookCounts",totalBookCounts);
        model.addAttribute("totalBookcopies",totalBookCopies);
        model.addAttribute("totalBorrows",totalBorrows);
        model.addAttribute("totalFines",totalFines);
        model.addAttribute("totalUnpaidFines",totalUnpaidFines);
        model.addAttribute("totalLostBooks",totalLostBooks);
        model.addAttribute("totalDamagedBooks",totalDamagedBooks);


//        System.out.println(totalBookCopies);
//        System.out.println(totalReaderCounts);
//        System.out.println(totalBookCounts);
//        System.out.println(totalBorrows);
//        System.out.println(totalFines);
//        System.out.println(totalUnpaidFines);
//        System.out.println(totalLostBooks);
//        System.out.println(totalDamagedBooks);
        return "admin/index";
    }
}
