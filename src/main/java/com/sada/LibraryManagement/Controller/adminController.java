package com.sada.LibraryManagement.Controller;

import com.sada.LibraryManagement.Service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class adminController {
    @Autowired
    private adminService service;
    @PutMapping("admin/register")
    public ResponseEntity<?> registerUser(@RequestBody String username) {
        return new ResponseEntity<>(service.register(username), HttpStatus.OK);
    }
}
