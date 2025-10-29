package com.sada.LibraryManagement.Eceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RessponseModel {
    String message;
    private boolean success;
    private HttpStatus status;
}
