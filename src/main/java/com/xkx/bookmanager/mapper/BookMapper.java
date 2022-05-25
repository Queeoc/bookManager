package com.xkx.bookmanager.mapper;

import com.xkx.bookmanager.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    List<Book> getAllBook();
    Book getBookById(String bookId);
    void updateBook(Book book);
    void updateBookBasic(Book book);
    void deleteBook(String bookId);
    void addBook(Book book);
    List<Book> searchBook(String keyword);
    void borrowBookById(String bookId);
    List<Book> getBookByIsbn(String isbn);
    void returnBookById(String bookId);
    void updateBookBarcodeByIsbn(Book book);
    void lostBook(String bookId);
    void damageBook(String bookId);

    int getTotalBookCounts();

    int getTotalBookCopies();

    int getTotalLostBooks();

    int getTotalDamagedBooks();

    List<Book> searchBookByLocation(String floor, String face, String column, String row);
}
