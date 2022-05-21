package com.owntech.mongodb.demo.repository;

import com.owntech.mongodb.demo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {
    Book findByName(String name);
}
