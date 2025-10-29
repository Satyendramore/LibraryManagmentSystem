package com.sada.LibraryManagement.Controller;

import com.sada.LibraryManagement.Model.Bookdetails;
import com.sada.LibraryManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("admin/books")
@PreAuthorize("hasRole('ADMIN')")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<?> getAllBooks() {

        return new ResponseEntity<>(service.getBooks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Bookdetails details) {
        return new ResponseEntity<>(service.addBook(details), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        return new ResponseEntity<>(service.getBook(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(@RequestBody Bookdetails details) {
        return new ResponseEntity<>(service.updateBook(details), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        return new ResponseEntity<>(service.deleteBook(id), HttpStatus.OK);
    }
}
