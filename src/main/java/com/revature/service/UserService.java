package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service(value="userService")
@CrossOrigin(origins = "http://localhost:4200")
public class UserService {
	
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
	public User authenticate(String username, String password) {
	    System.out.println("username is " + username);
	    System.out.println("password is " + password);

	    // Retrieve the user from the database by username
	    User user = this.userRepository.findUserByUsername(username);

	    // Check if the user exists and the password matches
	    if (user != null && passwordEncoder.matches(password, user.getPwd())) {
	        // Password matches, return the user
	        return user;
	    } else {
	        // Either the user doesn't exist or the password doesn't match
	        return null;
	    }
	}
	
	public User findUserByUsername(String username) {
		return this.userRepository.findUserByUsername(username);
	}
	public int findUseridByUsername(String username) {
		System.out.println("username is currently " + username);
		User user = this.userRepository.findUserByUsername(username);
		return user.getProfileid();
	}
	public String findUsernameByUserid(int userid) {
		User user = this.userRepository.findUsernameByProfileid(userid);
		return user.getUsername();
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	public void insertUser(User u) {
		System.out.println("hit the user service and username is" + u.getUsername());
		String hashedPassword = passwordEncoder.encode(u.getPwd());
        u.setPwd(hashedPassword);

        this.userRepository.save(u);
	}
	
}
