package com.info.learn.MyFirstSPringBoot.dao;

import com.info.learn.MyFirstSPringBoot.entity.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookDao extends CrudRepository<Book,Integer> {


}
