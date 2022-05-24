package com.xkx.bookmanager.controller.user;

import com.xkx.bookmanager.controller.admin.AdminReaderController;
import com.xkx.bookmanager.mapper.FineMapper;
import com.xkx.bookmanager.mapper.RecordMapper;
import com.xkx.bookmanager.pojo.Fine;
import com.xkx.bookmanager.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user/history")
public class history {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private FineMapper fineMapper;

    @RequestMapping("getAll")
    private String getAllHistory(Model model, HttpSession session) {
        String readerId = (String) session.getAttribute("username");
        List<Record> bookHistory = recordMapper.getOwnBookHistory(readerId);
        List<Record> bookBorrowed = recordMapper.getOwnRecord(readerId);
        List<Fine> fineList = fineMapper.getFineById(readerId);

        model.addAttribute("fineHistory", fineList);
        model.addAttribute("bookHistory", bookHistory);
        model.addAttribute("bookBorrowed", bookBorrowed);
        return "user/history";
    }


}
