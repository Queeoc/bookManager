package com.xkx.bookmanager.controller.admin;

import com.xkx.bookmanager.mapper.ParamMapper;
import org.apache.ibatis.binding.MapperMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Parameter;

@RequestMapping("/admin")
@Controller
public class AdminCategoryController {

    @Autowired
    private ParamMapper paramMapper;

    @RequestMapping("/category/add")
    public String add(String category){
        paramMapper.addCategory(category);

        return "redirect:/admin/system/getAll";
    }
}
