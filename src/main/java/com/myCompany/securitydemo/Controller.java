package com.myCompany.securitydemo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    List student = new ArrayList(List.of(new Student("Ansar",12,19),new Student("saad",12,20)));

    @RequestMapping("csrf")
    public CsrfToken csrfToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }
    @PostMapping("addStd")
    public List<Student> addStudent(@RequestBody Student stud){
        student.add(stud);
        return  student;
    }
    @GetMapping("/hello")
    public String getProduct() {
        return "hello";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String getProduct1() {
        return "hello USER";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getProduct2() {
        return "hello ADMIN";
    }

}
