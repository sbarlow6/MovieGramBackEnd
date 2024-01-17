package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.model.User;

@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findUserByUsernameAndPwd(String username, String password);
	public User findUserByUsername(String username);
	public User findUsernameByProfileid(int userid);
	public List<User> findAll();
	<U extends User> U save(U u);
	void deleteByProfileid(Integer u);
}
