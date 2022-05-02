package com.xkx.bookmanager.pojo;


import com.mysql.cj.jdbc.Blob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

	private byte[] barcode;
    private String readerId;
    private String address;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;
    private String name;
    private String phoneNumber;

    
}
