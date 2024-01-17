package com.revature.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController(value = "loginController")
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	private static UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		LoginController.userService = userService;
	}
	public LoginController() {
		super();
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@CrossOrigin(origins = "http://localhost:4200")
	public User login(@RequestBody Map<String, String> credentials,
	                  HttpSession session) {
	    String username = credentials.get("username");
	    String password = credentials.get("password");
		System.out.println(username);
		System.out.println(password);
		User user = userService.authenticate(username, password);
		if (user != null) {
			session.setAttribute("USER", user);
		} else {
			return null;
		}
		return user;
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public User getSession(HttpSession session) {
		if (session != null) {
			// log.info((User) session.getAttribute("USER"));
			return (User) session.getAttribute("USER");
		}
		return null;
	}
	
	@RequestMapping(value = "/loggingout", method = RequestMethod.GET)
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@RequestMapping(value = { "/checkuser" }, method = RequestMethod.POST)
	public boolean checkUser(@RequestParam("username") String username) {
		User user = userService.findUserByUsername(username);
		if (user == null) {
			System.out.println("User name isn't taken");
			return false;
		} else {
			System.out.println("User name is taken");
			return true;
		}
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public void register(@RequestParam("username") String username, 
						 @RequestParam("password") String password, 
						 @RequestParam("fullname") String fullname, 
						 @RequestParam("aboutme") String aboutme,
						 HttpSession session) {
						System.out.println("username is " + username);
						System.out.println("full name is : " + fullname);
						System.out.println("about me: " + aboutme);
						User newuser = new User(0, username, password, fullname, aboutme);
						userService.insertUser(newuser);
	}
	
	@RequestMapping(value = { "/unregister" }, method = RequestMethod.DELETE)
	@ResponseBody
	@Transactional
	public void unregister(HttpSession session) {
						User newuser = (User) session.getAttribute("USER");
						System.out.println("username being deleted is " + newuser.getUsername());
						System.out.println("full name being deleted is : " + newuser.getFullname());
						System.out.println("about me: " + newuser.getAboutme());
						userService.deleteUser(newuser.getProfileid());
						session.invalidate();
	}
}
