package com.RestApi.LMS.Controllers;

import com.RestApi.LMS.module.Book;
import com.RestApi.LMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Objectives
 * 1 GET all the available book
 * 2 POST the book
 * 3 DELETE/id the book With its id
 * 4 PATCH/id should update the book name with its id
 */


@RestController
@RequestMapping("/books")
public class bookController {
    @Autowired
    private BookService bookService;

    // this is for checking health of bookController
    @GetMapping("/health")
    public String bookControllerHealthcheck(){
        return "Book controller health check is live";
    }

    // this is for Getting all the books
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    // this is for uploading a book
    @PostMapping
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    // this is for deleting book with its id
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int bookId){
        return bookService.deleteBook(bookId);
    }

    //this is for updating book
    @PatchMapping("/{id}")
    public Book updateBook(@PathVariable("id") int id,@RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @PatchMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable("bookId") int bookId,@PathVariable("userId") int userId){
        Book BorrowedBook = bookService.borrowBook(bookId,userId);
        if (BorrowedBook!=null){
            return ResponseEntity.ok(BorrowedBook);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable int bookId){
        Book ReturnedBook= bookService.returnBook(bookId);
        if (ReturnedBook!=null){
            return ResponseEntity.ok(ReturnedBook);
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}
