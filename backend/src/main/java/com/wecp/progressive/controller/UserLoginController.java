package com.wecp.progressive.controller;
//dei
import com.wecp.progressive.dto.LoginRequest;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.jwt.JwtUtil;
import com.wecp.progressive.repository.UserRepository;
import com.wecp.progressive.service.impl.UserLoginServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserLoginServiceImpl userLoginService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try{
        return new ResponseEntity<>(userLoginService.createUser(user),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {

        try{
        Authentication authentication= authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        
       

        User user=userRepository.findByUsername(loginRequest.getUsername());

        if(user==null)
        {
            return ResponseEntity.status(401).body("Invalid");
        }
         String token=jwtUtil.generateToken(user.getUsername());

         Map<String,Object> response = new HashMap<>();
         response.put("token",token);
         response.put("role",user.getRole());
         response.put("id",user.getUserId());
         return ResponseEntity.ok(response);

        // LoginRequest loginResponse= new LoginRequest(token, user.getRole(), user.getUserId(), studentId, teacherId);
        // return new ResponseEntity<>(loginRequest, HttpStatus.OK);
    }
    catch(Exception e){
        return ResponseEntity.status(401).body("Invalid");
    }
}


}