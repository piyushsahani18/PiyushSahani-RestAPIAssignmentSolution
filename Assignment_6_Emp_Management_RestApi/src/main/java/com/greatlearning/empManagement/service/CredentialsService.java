package com.greatlearning.empManagement.service;

import java.util.List;

import com.greatlearning.empManagement.entities.Role;
import com.greatlearning.empManagement.entities.User;

public interface CredentialsService {

	Role addNewRole(String name);

	User addNewUser(String username, String password, String role_name);
	
	List<Role> listAllRoles();
}