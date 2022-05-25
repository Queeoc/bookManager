package com.xkx.bookmanager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ParamMapper {

    List<String> getAllCategories();
}
