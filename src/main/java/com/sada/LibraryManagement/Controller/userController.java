package com.sada.LibraryManagement.Controller;

import com.sada.LibraryManagement.Model.Userinfo;
import com.sada.LibraryManagement.Service.jwtservice;
import com.sada.LibraryManagement.Service.userService;
import com.sada.LibraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class userController {
    @Autowired
    private userService service;

    @PostMapping("public/register")
    public ResponseEntity<?> registerUser(@RequestBody Userinfo user) {
        return new ResponseEntity<>(service.register(user), HttpStatus.OK);
    }





    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtservice jservice;

    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping("public/login")
    public String login(@RequestBody Userinfo u) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(u.getUsername(), u.getPassword())
        );

        if (auth.isAuthenticated()) {
            return jservice.generateToken(u.getUsername(), List.of("ROLE_USER")); // default role
        } else {
            return "fail";
        }
    }




}
