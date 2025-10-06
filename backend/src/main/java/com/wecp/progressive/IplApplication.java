package com.wecp.progressive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wecp.progressive.jwt.JwtUtil;

import io.jsonwebtoken.Claims;

@SpringBootApplication
public class IplApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to Ipl Progressive Project!");
        // System.out.println("Hello IPL Progressive Project");
        // JwtUtil jwtUtil = new JwtUtil();
        // String str = jwtUtil.generateToken("krish");
        // System.out.println(str);
        // System.out.println("----------------------");
        // Claims ans = jwtUtil.extractAllClaims(str);
        // System.out.println(ans);
       SpringApplication.run(IplApplication.class, args);
    }
}
