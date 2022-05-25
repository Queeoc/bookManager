package com.xkx.bookmanager.controller.admin;

import com.xkx.bookmanager.mapper.FineMapper;
import com.xkx.bookmanager.mapper.ReaderMapper;
import com.xkx.bookmanager.mapper.RecordMapper;
import com.xkx.bookmanager.mapper.UserMapper;
import com.xkx.bookmanager.pojo.Fine;
import com.xkx.bookmanager.pojo.Reader;
import com.xkx.bookmanager.pojo.Record;
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

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private FineMapper fineMapper;

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

    @RequestMapping("/searchById")
    public String searchById(Model model, String readerId){

        List<Record> bookHistory = recordMapper.getOwnBookHistory(readerId);
        List<Record> bookBorrowed = recordMapper.getOwnRecord(readerId);
        List<Fine> fineList = fineMapper.getFineById(readerId);


        model.addAttribute("fineHistory",fineList);
        model.addAttribute("bookHistory",bookHistory);
        model.addAttribute("bookBorrowed",bookBorrowed);


        return "admin/reader_info";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Model model, String readerId){

        if(recordMapper.isBorrowedBookById(readerId) != 0){
            model.addAttribute("failed",true);
            List<Reader> readers = readerMapper.getAllReader();
            model.addAttribute("readers", readers);
            return "admin/readers";
        }else{
            userMapper.deleteById(readerId);
            readerMapper.deleteById(readerId);
            return "redirect:/admin/reader/getAll";
        }
    }

}
