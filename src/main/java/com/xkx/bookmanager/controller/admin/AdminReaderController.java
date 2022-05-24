package com.xkx.bookmanager.controller.admin;

import com.xkx.bookmanager.mapper.ReaderMapper;
import com.xkx.bookmanager.mapper.UserMapper;
import com.xkx.bookmanager.pojo.Reader;
import com.xkx.bookmanager.util.barCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/reader")
public class AdminReaderController {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Reader> readers = readerMapper.getAllReader();
        model.addAttribute("readers", readers);
        return "admin/readers";
    }

    @RequestMapping("/registerById")
    public String registerById(String username,String password){
        userMapper.insertUser(username,password, "user");
        // userMapper.insertUser("test","password", "user");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String path = "D:\\pillar\\" + username + ".jpg";
        barCodeUtil.getBarCode(username,path);
        String barcode = "/" + username + ".jpg";

        Reader reader=new Reader(barcode,username,null,null,date,"游客-" + username,null);
        readerMapper.addReader(reader);

        return "redirect:/admin/reader/getAll";
    }

}
