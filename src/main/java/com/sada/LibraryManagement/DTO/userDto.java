package com.sada.LibraryManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class userDto {
    private String username;
    private String bookname;
    private Date DueDate;
    private int quantity;
}
