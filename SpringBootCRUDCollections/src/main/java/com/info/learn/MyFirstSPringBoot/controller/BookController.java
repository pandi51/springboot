package com.info.learn.MyFirstSPringBoot.controller;

import com.info.learn.MyFirstSPringBoot.entity.Book;
import com.info.learn.MyFirstSPringBoot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/app")
public class BookController {

    @Autowired
    private BookService service;

    @RequestMapping(value = "/app",method = RequestMethod.GET)
    public String greet(){
       return  service.greet();
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return  service.createBook(book);
    }
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET)
    public Book getBook(@PathVariable(value = "bookId") Integer bookId){
        return  service.getBook(bookId);
    }

    @GetMapping(value = "/book")
    public List<Book> getAllBooks(){
        return  service.getAllBooks();
    }
    @RequestMapping(value = "/book",method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book){
        return  service.updateBook(book);
    }
    @DeleteMapping(value = "/book/{bookId}")
    public void deleteBook(@PathVariable(value = "bookId") Integer bookId){
        service.deleteBook(bookId);
    }
   }
