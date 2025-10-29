package com.sada.LibraryManagement.Service;

import com.sada.LibraryManagement.Eceptions.objectNootFound;
import com.sada.LibraryManagement.Model.Bookdetails;
import com.sada.LibraryManagement.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public List<Bookdetails> getBooks() {
        return bookRepo.findAll();
    }

    public String addBook(Bookdetails details) {
         bookRepo.save(details);
         return "Book added successfully";
    }

    public Object getBook(String id) {
        Bookdetails bookdetails = bookRepo.findById(id).orElse(null);
        if (bookdetails == null) {
            throw new objectNootFound("book not found");
        }
        return bookdetails;
    }

    public String updateBook(Bookdetails details) {
        Bookdetails book=bookRepo.findById(details.getBookTitle()).orElse(null);
        if (book == null) {
            throw new objectNootFound("book not exist");
        }
        book.setBookTitle(details.getBookTitle());
        book.setBookAuthor(details.getBookAuthor());
        book.setIsbnNo(details.getIsbnNo());
        book.setQuantity(details.getQuantity()+book.getQuantity());
        book.setIsAvailable(details.getIsAvailable());
        bookRepo.save(book);
        return "Book updated successfully";

    }

    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Book deleted successfully";
    }
}
