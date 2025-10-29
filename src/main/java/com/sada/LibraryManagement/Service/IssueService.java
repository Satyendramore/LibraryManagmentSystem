package com.sada.LibraryManagement.Service;

import com.sada.LibraryManagement.DTO.userDto;
import com.sada.LibraryManagement.Eceptions.LimitExcced;
import com.sada.LibraryManagement.Eceptions.objectNootFound;
import com.sada.LibraryManagement.Model.Bookdetails;
import com.sada.LibraryManagement.Model.IssueRecord;
import com.sada.LibraryManagement.Model.Userinfo;
import com.sada.LibraryManagement.repository.BookRepo;
import com.sada.LibraryManagement.repository.RecordRepo;
import com.sada.LibraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IssueService {
    @Autowired
    private RecordRepo repo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;
    public Object saveissue(userDto issue) {
        Userinfo userDetails = userRepo.findById(issue.getUsername()).orElse(null);
        if (userDetails == null) {
           throw new objectNootFound("User not found");
        }
        Bookdetails bookDetails = bookRepo.findById(issue.getBookname()).orElse(null);
        Bookdetails book = new Bookdetails();
        if (bookDetails == null) {
           throw new objectNootFound("Book not found");
        }
        if (issue.getQuantity() > bookDetails.getQuantity()) {
            throw new LimitExcced("limit exceeded");
        }
        bookDetails.setQuantity(bookDetails.getQuantity() - issue.getQuantity());
        if (bookDetails.getQuantity() == 0) {
            bookDetails.setIsAvailable(false);
        }
        bookRepo.save(bookDetails);

        IssueRecord record = new IssueRecord();
        record.setReturnDate(null);
        record.setIssueDate(new Date());
        record.setDueDate(issue.getDueDate());
        record.setBook(bookDetails);
        record.setUser(userDetails);
        repo.save(record);
        return record.getId();

    }


    public Object updatereturn(int Id) {
        IssueRecord r= repo.findById(Id).orElse(null) ;
        if(r==null){
            throw new objectNootFound("book not issued yet");
        }
        r.setReturnDate(new Date());
        repo.save(r);
         return "successfully returned issue";

    }
}
