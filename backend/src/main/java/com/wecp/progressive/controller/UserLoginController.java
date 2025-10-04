package com.wecp.progressive.controller;

import com.wecp.progressive.dto.LoginRequest;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.service.impl.UserLoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserLoginController {
    @Autowired
    private UserLoginServiceImpl userLoginServiceImpl;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(User user) {
        return new ResponseEntity<>(userLoginServiceImpl.createUser(user),HttpStatus.OK);
    }

    public ResponseEntity loginUser(LoginRequest loginRequest) {
        //userLoginServiceImpl.
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
