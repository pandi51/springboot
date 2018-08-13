package com.info.learn.MyFirstSPringBoot.app;

import com.info.learn.MyFirstSPringBoot.entity.Book;
import com.info.learn.MyFirstSPringBoot.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value ="com" )
public class MyFirstSPringBootApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext =  SpringApplication.run(MyFirstSPringBootApplication.class, args);
        BookService appService= applicationContext.getBean("appService",BookService.class);
        Book book = new Book();
        book.setName("Raghav");
        appService.createBook(book);
		System.out.println("Started Application...");
	}

}
