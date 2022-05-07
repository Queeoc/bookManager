package com.xkx.bookmanager.controller.user;

import com.xkx.bookmanager.mapper.ReserveMapper;
import com.xkx.bookmanager.pojo.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/reserve")
public class UserReserveController {

    @Autowired
    ReserveMapper reserveMapper;

    @RequestMapping("/getAll")
    public String getAllReserveByName(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        List<Reserve> Books = reserveMapper.getReserveBooksByReaderId(username);

        model.addAttribute("ReserveBooks",Books);


        return "/user/reserve_info";
    }

}
