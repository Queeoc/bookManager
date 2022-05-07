package com.xkx.bookmanager.mapper;

import com.xkx.bookmanager.pojo.Reserve;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReserveMapper {

    List<Reserve> getReserveBooksByReaderId(String readerId);

    void insertReserveBook(Reserve reserveBook);
}
