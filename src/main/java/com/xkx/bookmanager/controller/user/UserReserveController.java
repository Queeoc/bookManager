package com.xkx.bookmanager.controller.user;

import com.xkx.bookmanager.mapper.BookMapper;
import com.xkx.bookmanager.mapper.RecordMapper;
import com.xkx.bookmanager.mapper.ReserveMapper;
import com.xkx.bookmanager.pojo.Record;
import com.xkx.bookmanager.pojo.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/reserve")
public class UserReserveController {

    @Autowired
    ReserveMapper reserveMapper;
    @Autowired
    RecordMapper recordMapper;
    @Autowired
    BookMapper bookMapper;

    @RequestMapping("/getAll")
    public String getAllReserveByName(HttpSession session, Model model){
        String username = (String) session.getAttribute("username");
        List<Reserve> Books = reserveMapper.getReserveBooksByReaderId(username);
        List<Record> record = recordMapper.getOwnRecord(username);
        int reserveNum=Books.size(); //预定书目
        int recordNum=record.size(); //已有记录

        if(reserveNum+recordNum>5){
            model.addAttribute("isFull",1);
        }
        else {
            model.addAttribute("isFull",0);
        }

        model.addAttribute("reserveNum",reserveNum);
        model.addAttribute("ReserveBooks",Books);
        return "/user/reserve_info";
    }

    @RequestMapping("/delete/{id}")
    public String deleteReserveByName(HttpSession session, Model model, @PathVariable("id") String id){
        String username = (String) session.getAttribute("username");
        List<Reserve> Books = reserveMapper.getReserveBooksByReaderId(username);
        reserveMapper.deleteReservation(id);
        bookMapper.returnBookById(id);


        model.addAttribute("ReserveBooks",Books);
        return "redirect:/user/reserve/getAll";
    }

}
