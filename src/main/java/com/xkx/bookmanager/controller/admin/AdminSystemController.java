package com.xkx.bookmanager.controller.admin;

import com.xkx.bookmanager.mapper.ParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/system")
public class AdminSystemController {
    @Autowired
    private ParamMapper paramMapper;



    @RequestMapping("/getAll")
    public String getAll(Model model){

        List<String> categories = paramMapper.getAllCategories();

        model.addAttribute("categories",categories);
        model.addAttribute("face",paramMapper.getFace());
        model.addAttribute("column",paramMapper.getColumn());
        model.addAttribute("floor",paramMapper.getFloor());
        model.addAttribute("row",paramMapper.getRow());


        return "admin/system";
    }
}
