package com.xkx.bookmanager.controller.user;

import com.xkx.bookmanager.mapper.ReaderMapper;
import com.xkx.bookmanager.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserReaderController {

    @Autowired
    private ReaderMapper readerMapper;

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
