package com.sada.LibraryManagement.Service;

import com.sada.LibraryManagement.Eceptions.userAllreadyExist;
import com.sada.LibraryManagement.Model.Userinfo;
import com.sada.LibraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class userService {

    @Autowired
    private UserRepo userRepo;

     private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    public Object register(Userinfo user) {
        if (userRepo.existsById(user.getUsername())) {
            throw new userAllreadyExist("user allready exist");
        }

        // Default role USER
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(new HashSet<>());
        }
        user.getRoles().add("USER");
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepo.save(user);
    }
}
