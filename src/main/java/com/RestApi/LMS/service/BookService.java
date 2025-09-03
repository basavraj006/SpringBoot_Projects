package com.RestApi.LMS.service;

import com.RestApi.LMS.dao.BookRepository;
import com.RestApi.LMS.module.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public String deleteBook(int id){
        bookRepository.deleteById(id);
        return "Book with id "+id+" is deleted";
    }

    public Book updateBook(int id,Book book){
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book savedbook = bookOptional.get();

        if (book.getBookName() != null ){
            savedbook.setBookName(book.getBookName());
        }
        return bookRepository.save(savedbook);
    }


}
