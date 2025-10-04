package com.wecp.progressive.service.impl;

import com.wecp.progressive.entity.User;
import com.wecp.progressive.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer userId) {
       return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User u = userRepository.findById(user.getUserId()).orElseThrow(() -> new RuntimeException("poiu"));
        u.setEmail(user.getEmail());
        u.setFullName(user.getFullName());
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
        u.setRole(user.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
      User user=userRepository.findByUsername(username);
      if(user==null){
        throw new UsernameNotFoundException("User not found");
      }
      return org.springframework.security.core.userdetails.User
      .withUsername(user.getUsername())
      .password(user.getPassword())
      .roles(user.getRole())
      .build();

    }
}
