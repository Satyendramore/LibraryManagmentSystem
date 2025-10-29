package com.sada.LibraryManagement.Controller;

import com.sada.LibraryManagement.DTO.userDto;
import com.sada.LibraryManagement.Model.Bookdetails;
import com.sada.LibraryManagement.Model.IssueRecord;
import com.sada.LibraryManagement.Service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("user/books")
@PreAuthorize("hasRole('USER')")
public class issuerController {
    @Autowired
    private IssueService service;
    @PostMapping("/issue")
    public ResponseEntity<?> addBook(@RequestBody userDto issue) {
        return new ResponseEntity<>(service.saveissue(issue), HttpStatus.CREATED);
    }
    @PutMapping("/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable int id) {
        return new ResponseEntity<>(service.updatereturn(id),HttpStatus.ACCEPTED);
    }


}
