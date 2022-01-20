package com.greatlearning.empManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.empManagement.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User getUserByUsername(String username);
	
}
