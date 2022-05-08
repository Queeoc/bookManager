package com.xkx.bookmanager.controller.user;

import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.mapper.RecordMapper;
import com.xkx.bookmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user/record")
public class UserRecordController {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/getOwnRecord")
    public String ownRecord(Model model, HttpSession session) {
        /*得到用户名*/
        String username = (String) session.getAttribute("username");
        List<Record> record = recordMapper.getOwnRecord(username);
        Iterator<Record> it = record.iterator();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int sumFine = 0;

        Date now = new Date();//现在
        long date1 = now.getTime();
        while (it.hasNext()) {
            Record r = (Record) it.next();
            long date2 = r.getLatestFineDay().getTime();   //应还

            if (date1 - date2 > 0) {
                sumFine += (int) ((date1 - date2) / (1000 * 3600 * 24));
                r.setFine((int) ((date1 - date2) / (1000 * 3600 * 24)));
            } else {
                r.setFine(0);
            }
        }

        model.addAttribute("fine", sumFine);

        model.addAttribute("records", record);
        return "user/ownRecord";
    }


    @RequestMapping("/renewBook/{bookId}")
    public String renewBook(Model model, HttpSession session, @PathVariable("bookId") String id) {
        /*得到用户名*/
        String username = (String) session.getAttribute("username");
        /*修改退书时间*/
        Record r = recordMapper.getRecord(id, username);
        Calendar returnTime = Calendar.getInstance();

        Date returntime = returnTime.getTime();
        recordMapper.updateRecordById(username, id, returntime);
        /*更新列表*/
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "redirect:/user/record/getOwnRecord";
    }

    @RequestMapping("/returnBook/{bookId}")
    public String returnBook(Model model, HttpSession session, @PathVariable("bookId") String id) {
        /*得到用户名*/
        String username = (String) session.getAttribute("username");
        /*还书*/
        recordMapper.deleteRecord(id, username);
        bookMapper.returnBookById(id);
        /*更新列表*/
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("records", records);
        return "redirect:/user/record/getOwnRecord";
    }

    @RequestMapping("/returnBook")
    public String payMoney(Model model, HttpSession session) {
        /*得到用户名*/
        String username = (String) session.getAttribute("username");
        /*交钱*/
        List<Record> record = recordMapper.getOwnRecord(username);
        Calendar today = Calendar.getInstance();
        Iterator it = record.iterator();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        int sumFine = 0;
        while (it.hasNext()) {
            Record r = (Record) it.next();
            Date date1 = new Date();//现在
            Date date2 = r.getLatestFineDay();   //应还

            if ((int) (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24) > 0) ;
            {
                sumFine += (int) (date2.getTime() - date1.getTime());
            }
        }

        /*更新列表*/
        List<Record> records = recordMapper.getOwnRecord(username);
        model.addAttribute("fine", sumFine);
        model.addAttribute("records", records);
        return "redirect:/user/record/getOwnRecord";
    }

}
