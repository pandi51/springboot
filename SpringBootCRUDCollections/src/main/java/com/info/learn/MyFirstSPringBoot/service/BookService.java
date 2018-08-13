package com.info.learn.MyFirstSPringBoot.service;

import com.info.learn.MyFirstSPringBoot.dao.BookDao;
import com.info.learn.MyFirstSPringBoot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public String greet() {
        return "Hello";
    }

    public Book createBook(Book book) {
        return bookDao.save(book);
    }


    public Book getBook(Integer id) {
        return bookDao.findById(id);
    }
    public List<Book> getAllBooks(){
        return bookDao.findAll();
    }

    public Book updateBook(Book book) {
        return bookDao.update(book);
    }

    public void deleteBook(Integer bookId) {
        bookDao.delete(bookId);
    }
}
