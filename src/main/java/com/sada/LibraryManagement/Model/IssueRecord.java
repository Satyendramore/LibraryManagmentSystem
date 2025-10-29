package com.sada.LibraryManagement.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueRecord {
    @Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date IssueDate;
    Date ReturnDate;
    Date DueDate;
    @ManyToOne(cascade = CascadeType.ALL)
    Userinfo user;
    @ManyToOne(cascade = CascadeType.ALL)
    Bookdetails book;

}
