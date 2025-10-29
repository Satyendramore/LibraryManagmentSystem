package com.sada.LibraryManagement.Service;

import com.sada.LibraryManagement.Model.UserPrincipal;
import com.sada.LibraryManagement.Model.Userinfo;
import com.sada.LibraryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class userdetailservice implements UserDetailsService {

    @Autowired
    private UserRepo user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userinfo u = user.findById(username).orElse(null);
        if (u == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(u);
    }
}
