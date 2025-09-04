package com.vizionExl.UserLogin.Dao;

import com.vizionExl.UserLogin.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByMailId(String mailId);
}
