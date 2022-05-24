package com.xkx.bookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.parameters.P;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private String bookId;
	private String readerId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date latestFineDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private int fine;
    private String bookBarcode;
    private int state;

    public Record(String id, String username, Date borrowDate, Date latestFineDay) {
        this.bookId=id;
        this.readerId=username;
        this.borrowDate=borrowDate;
        this.latestFineDay=latestFineDay;
    }

    public Record(String readerId, String username, Date borrowDate, Date returnDate, int state){
        this.bookId = readerId;
        this.readerId = username;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.state = state;
    }


}
