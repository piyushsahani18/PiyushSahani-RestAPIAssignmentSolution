package com.greatlearning.empManagement;

import java.util.ArrayList;import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.empManagement.entities.Role;
import com.greatlearning.empManagement.entities.User;
import com.greatlearning.empManagement.repository.UserRepository;

@SpringBootApplication
public class Emp_Management_RestApiApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Emp_Management_RestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1);
		user.setUsername("PiyushSahani");
		user.setPassword(new BCryptPasswordEncoder().encode("Project"));
		List<Role> roles = new ArrayList<>();
		roles.add(new Role(1,"ADMIN"));
		user.setListOfRoles(roles);
		userRepository.save(user);
	}

}
