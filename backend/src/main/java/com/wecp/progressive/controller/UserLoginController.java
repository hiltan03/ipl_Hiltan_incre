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

// ///
// package com.wecp.progressive.controller;

// import com.wecp.progressive.dto.LoginRequest;
// import com.wecp.progressive.dto.LoginResponse;
// import com.wecp.progressive.dto.UserRegistrationDTO;
// import com.wecp.progressive.entity.User;
// import com.wecp.progressive.jwt.JwtUtil;
// import com.wecp.progressive.service.impl.UserLoginServiceImpl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/user")
// public class UserLoginController {

//     @Autowired
//     private UserLoginServiceImpl userLoginService;

//     @Autowired
//     private AuthenticationManager authenticationManager;

//     @Autowired
//     private JwtUtil jwtUtil;

//     @PostMapping("/register")
//     public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
//         try
//         {
//             userLoginService.registerUser(registrationDTO);
//             return new ResponseEntity<>(HttpStatus.OK);
//         }
//         catch(RuntimeException e)
//         {
//             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//         }
//     }

//     @PostMapping("/login")
//     public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {

//         Authentication authentication= authenticationManager.authenticate(
//             new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
//         );

//         String token=jwtUtil.generateToken(loginRequest.getUsername());

//         User user=userLoginService.getUserByUsername(loginRequest.getUsername());

//         Integer studentId=null;
//         Integer teacherId=null;

//         if(user.getRole().equals("STUDENT") && user.getStudent()!=null)
//         {
//             studentId=user.getStudent().getStudentId();
//         }

//         else if(user.getRole().equals("TEACHER") && user.getTeacher()!=null)
//         {
//             teacherId= user.getTeacher().getTeacherId();
//         }

//         LoginResponse loginResponse= new LoginResponse(token, user.getRole(), user.getUserId(), studentId, teacherId);
//         return new ResponseEntity<>(loginResponse, HttpStatus.OK);
//     }

//     @GetMapping("/user/{userId}")
//     public ResponseEntity<?> getUserDetails(@PathVariable int userId) {
//         try
//         {
//             User user= userLoginService.getUserDetails(userId);
//             return new ResponseEntity<>(user, HttpStatus.OK);
//         }
//         catch(RuntimeException e)
//         {
//             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//         }       
        
//     }
// }
