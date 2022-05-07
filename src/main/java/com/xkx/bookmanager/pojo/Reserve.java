package com.xkx.bookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {

    private String bookId;
    private String name;
    private String readerId;
    private String reserveTime;
    private String barcode;
    private String isbn;
    private String bookName;
}
