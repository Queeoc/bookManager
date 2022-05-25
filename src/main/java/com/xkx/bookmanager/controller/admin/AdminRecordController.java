package com.xkx.bookmanager.controller.admin;

import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.mapper.RecordMapper;
import com.xkx.bookmanager.mapper.SystemMapper;
import com.xkx.bookmanager.pojo.Record;
import com.xkx.bookmanager.pojo.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/record")
public class AdminRecordController {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private SystemMapper systemMapper;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Record> records = recordMapper.getAllRecord();

        System systemParameter = systemMapper.getSystemParameter();
        int timeLimit = systemParameter.getTimeLimit();

        for(Record record:records){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(record.getBorrowDate());
            calendar.add(Calendar.DATE, timeLimit);
            Date t =  calendar.getTime();
            record.setLatestFineDay(t);

            record.setBookBarcode("/"+record.getBookId()+".jpg");
        }

        model.addAttribute("records", records);

        return "admin/records";
    }
    @RequestMapping("/returnById")
    public String returnBookById(Model model,String bookId ){

        Record record = recordMapper.getRecordByBookId(bookId);
        recordMapper.insertBookHistory(record);
        recordMapper.returnById(bookId);
        bookMapper.returnBookById(bookId);


        return "redirect:/admin/record/getAll";
    }
}
