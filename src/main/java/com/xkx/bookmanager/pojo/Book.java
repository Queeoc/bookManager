package com.xkx.bookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookId;
    private String bookName;
    private String author;
    private String publisher;
    private String isbn;
    private String description;
    private String category;
    private String price;

    private String publishTime;
    //state 有四个取值，0为可借状态，1为被借状态，2为丢失状态，3为损坏状态
    private int state;
    private String face;
    private String column;
    private String row;
    private String floor;
    private String bookBarcode;
    private String picture;



}
