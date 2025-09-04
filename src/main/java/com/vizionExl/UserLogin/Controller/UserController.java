package com.vizionExl.UserLogin.Controller;


import com.vizionExl.UserLogin.Services.UserSevices;
import com.vizionExl.UserLogin.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserSevices userSevices;

    @GetMapping("/health")
    public String userhealthcheck(){
        return "user controller is live and working";
    }

    @GetMapping
    public List<User> getallUser(){
        return userSevices.getAllUser();
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userSevices.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int Userid){
        return userSevices.deleteUser(Userid);
    }

    @PatchMapping("/updateEmail/{id}")
    public User updateEmail(@PathVariable("id") int id,@RequestBody User mail){
        return userSevices.updateEmail(id, mail);
    }

    @PatchMapping("/updatePassword/{id}")
    public User updatePassword(@PathVariable("id") int id, @RequestBody User password){
        return userSevices.updatePassword(id, password);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        boolean isValid = userSevices.verifyLogin(user.getMailId(),user.getPassword());
        if (isValid){
            return "Login Successful";
        }
        else {
            return "Invalid email or password";
        }
    }
}
