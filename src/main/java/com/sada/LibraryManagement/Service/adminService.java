package com.sada.LibraryManagement.Service;

import com.sada.LibraryManagement.Eceptions.objectNootFound;
import com.sada.LibraryManagement.Model.Userinfo;
import com.sada.LibraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {
    @Autowired
    private UserRepo userRepo;
    public Object register(String username) {
        Userinfo user=userRepo.findById(username).orElse(null);
        if(user==null) {
            throw new objectNootFound("user not found");
        }
        userRepo.save(user);
        return "User is now admin";

    }
}
