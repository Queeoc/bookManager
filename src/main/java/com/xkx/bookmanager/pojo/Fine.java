package com.xkx.bookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fine {
    String readerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date fineDay;
    String fineCount;
    String bookId;
}
