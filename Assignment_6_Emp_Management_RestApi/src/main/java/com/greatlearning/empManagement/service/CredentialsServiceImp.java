package com.greatlearning.empManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.empManagement.entities.Role;
import com.greatlearning.empManagement.entities.User;
import com.greatlearning.empManagement.repository.RoleRepository;
import com.greatlearning.empManagement.repository.UserRepository;

@Service
public class CredentialsServiceImp implements CredentialsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role addNewRole(String name) {
		Role role = roleRepository.findRoleByName(name);
		if (role != null) 
			return role;
		role = new Role();
		role.setName(name);
		return roleRepository.save(role);
	}
	
	@Override
	public User addNewUser(String username, String password, String role_name) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		
		List<Role> roles = new ArrayList<>();
		Role role = roleRepository.findRoleByName(role_name);
		if (role == null)
			role = addNewRole(role_name);
		roles.add(role);
		user.setListOfRoles(roles);
		
		return userRepository.save(user);
	}

	@Override
	public List<Role> listAllRoles() {
		return roleRepository.findAll();
	}
	
}
