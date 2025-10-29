package com.sada.LibraryManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookdetails {
    @Id
    String bookTitle;
    String bookAuthor;
    String isbnNo;
    int quantity;
    Boolean isAvailable;

}
