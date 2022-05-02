package com.xkx.bookmanager.mapper;


import com.xkx.bookmanager.pojo.System;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SystemMapper {
    System getSystemParameter();

}
