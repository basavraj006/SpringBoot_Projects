package com.RestApi.LMS.Controllers;


import com.RestApi.LMS.module.User;
import com.RestApi.LMS.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/users")
public class userController {

    @Autowired
    private Userservice userservice;

    @GetMapping
    public List<User> getAllUser(){
        return userservice.findAll();
    }

    @PostMapping
    public User SaveUser(@RequestBody User user){
        return userservice.saveUser(user);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int UserId){
        return userservice.deleteUser(UserId);
    }
}
