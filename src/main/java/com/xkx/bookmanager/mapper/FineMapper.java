package com.xkx.bookmanager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FineMapper {

    int getTotalFines();


}
