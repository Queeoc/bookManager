package com.xkx.bookmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @RequestMapping({"/", "/index"})
    public String login(HttpSession session) {
        String username = (String) session.getAttribute("name");
        if (username == "root") {
            return "admin/index";
        } else {
            return "user/index";
        }
    }

    @RequestMapping({"/toLoginPage"})
    public String toLoginPage() {
        return "login";
    }


}
