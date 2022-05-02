package com.xkx.bookmanager.controller;

import com.xkx.bookmanager.mapper.SystemMapper;
import com.xkx.bookmanager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;
    private SystemMapper systemMapper;

    @RequestMapping("/toChPwdPage")
    public String toChangePasswordPage() {
        return "password";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session, String newPassword) {
        String username = (String) session.getAttribute("username");

        userMapper.changePassword(username, newPassword);
        return "redirect:/";
    }

    @RequestMapping("/checkPassword")
    @ResponseBody
    public String checkPassword(@RequestParam("password") String password, HttpSession session) {
        String username = (String) session.getAttribute("username");
        String realPassword = userMapper.getPassword(username);
        if (realPassword.equals(password))
            return "1";
        else
            return "0";
    }
}
