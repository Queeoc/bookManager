package com.xkx.bookmanager.controller;

import com.xkx.bookmanager.mapper.ReaderMapper;
import com.xkx.bookmanager.mapper.UserMapper;
import com.xkx.bookmanager.pojo.Reader;
import com.xkx.bookmanager.util.barCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ReaderMapper readerMapper;



    @RequestMapping("/register")
    public String register(String username,String password){
        userMapper.insertUser(username,password, "user");
        // userMapper.insertUser("test","password", "user");
        
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String path = "D:\\pillar\\" + username + ".jpg";
        barCodeUtil.getBarCode(username,path);
        String barcode = "/" + username + ".jpg";

        Reader reader=new Reader(barcode,username,null,null,date,"游客-" + username,null);
        readerMapper.addReader(reader);
        return "login";
    }

}
