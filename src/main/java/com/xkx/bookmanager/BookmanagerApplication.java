package com.xkx.bookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.xkx.bookmanager.config")
public class BookmanagerApplication{

    public static void main(String[] args) {
        SpringApplication.run(BookmanagerApplication.class, args);
    }
    

}
