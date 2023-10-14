package com.ozicode.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ozicode.userservice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
