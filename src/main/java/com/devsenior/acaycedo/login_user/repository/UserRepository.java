package com.devsenior.acaycedo.login_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.acaycedo.login_user.model.entity.User;

public interface UserRepository extends JpaRepository <User, String> {
    boolean existByUsernameAndPassword(String username, String password);
}
