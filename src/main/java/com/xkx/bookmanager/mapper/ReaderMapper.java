package com.xkx.bookmanager.mapper;

import com.xkx.bookmanager.pojo.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReaderMapper {
    List<Reader> getAllReader();
    String getReaderName(String readerId);
    Reader getReaderInfoByName(String name);
    void updateInfo(Reader reader);
    void addReader(Reader reader);
    Reader getReaderInfoByReaderId(String readerId);
    void deleteById(String readerId);
}
