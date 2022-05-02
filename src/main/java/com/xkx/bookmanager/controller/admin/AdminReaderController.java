package com.xkx.bookmanager.controller.admin;

import com.xkx.bookmanager.mapper.ReaderMapper;
import com.xkx.bookmanager.pojo.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/reader")
public class AdminReaderController {

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Reader> readers = readerMapper.getAllReader();
        model.addAttribute("readers", readers);
        return "admin/readers";
    }
}
