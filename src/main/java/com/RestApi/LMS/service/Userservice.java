package com.RestApi.LMS.service;

import com.RestApi.LMS.Repository.BookRepository;
import com.RestApi.LMS.Repository.UserRepository;
import com.RestApi.LMS.module.Book;
import com.RestApi.LMS.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User with id "+id+" is deleted";
    }
}
