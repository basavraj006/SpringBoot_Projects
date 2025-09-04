package com.vizionExl.UserLogin.Services;

import com.vizionExl.UserLogin.Dao.UserRepository;
import com.vizionExl.UserLogin.modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSevices {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User saveUser(User user ){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User with id " +id+" is deleted";
    }

    public User updateEmail(int id, User mail){
        Optional<User> userOptional = userRepository.findById(id);
        User savedmail=userOptional.get();

        if (mail.getMailId() != null ){
            savedmail.setMailId(mail.getMailId());
        }
        return userRepository.save(savedmail);

    }

    public User updatePassword(int id, User password){
        Optional<User> optionalUser= userRepository.findById(id);
        User savedPassword = optionalUser.get();

        if (password.getPassword() !=null){
            savedPassword.setPassword(passwordEncoder.encode(password.getPassword()));
        }
        return userRepository.save(savedPassword);
    }

    public boolean verifyLogin( String mailId, String password){
        User user= userRepository.findByMailId(mailId);
        return user != null &&  passwordEncoder.matches(password,user.getPassword());
    }
}
