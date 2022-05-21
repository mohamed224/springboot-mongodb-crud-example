package com.owntech.mongodb.demo.restcontroller;

import com.owntech.mongodb.demo.model.Book;
import com.owntech.mongodb.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id){
        return bookRepository.findById(id).get();
    }

    @GetMapping("/findByName")
    public Book findByName(@RequestParam String name){
        return bookRepository.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
    }
}
