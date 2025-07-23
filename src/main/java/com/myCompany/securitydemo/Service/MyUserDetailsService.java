package com.myCompany.securitydemo.Service;

import com.myCompany.securitydemo.DAO.UserRepo;
import com.myCompany.securitydemo.Model.User;
import com.myCompany.securitydemo.Model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user= repo.findByUserName(userName);

        if (user==null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user);
    }
}
