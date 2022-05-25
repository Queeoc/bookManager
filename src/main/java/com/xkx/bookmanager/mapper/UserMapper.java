package com.xkx.bookmanager.mapper;

import com.xkx.bookmanager.pojo.Reader;
import com.xkx.bookmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    User getUserByUsername(String username);
    void changePassword(String username, String newPassword);
    String getPassword(String username);
    void insertUser(String username, String password,String role);

    int getTotalReaderCounts();
    void deleteById(String readerId);
}
