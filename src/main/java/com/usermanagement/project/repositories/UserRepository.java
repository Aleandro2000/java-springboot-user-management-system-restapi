package com.usermanagement.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.project.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    boolean findByEmail(String email);
}
