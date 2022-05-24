package com.xkx.bookmanager.mapper;

import com.xkx.bookmanager.pojo.Fine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FineMapper {

    int getTotalFines();

    List<Fine> getFineById(String readerId);
    void addFineRecord(Fine fine);
//    Fine getFineById(String readerId);
}
