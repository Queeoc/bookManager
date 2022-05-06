package com.xkx.bookmanager.mapper;

import com.xkx.bookmanager.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface RecordMapper {
    List<Record> getAllRecord();
    List<Record> getOwnRecord(String readerId);
    void updateRecordById(String readerId, String bookId, Date returnDate);

    void insertRecord(Record record);
    int getRecordNum(String readerId);
    Record getRecord(String bookId,String readerId);
    void deleteRecord(String bookId,String readerId);

    void returnById(String bookId);

}
