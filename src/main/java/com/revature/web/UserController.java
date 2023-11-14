package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.service.UserService;
import com.revature.model.Review;
import com.revature.model.User;

@RestController(value="userController")
@CrossOrigin()
public class UserController {

	private static UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		UserController.userService = userService;
	}
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getAllUsers(){
		return UserController.userService.findAll();
	}
	@RequestMapping(value = "/userbyname", method = RequestMethod.GET)
    public int userByName(@RequestParam String username){
		System.out.println("hit userbyname");
        int userid = userService.findUseridByUsername(username);
        return userid;

    }
	@RequestMapping(value = "/namebyuser", method = RequestMethod.GET)
	
    public String userByName(@RequestParam int userid){
		System.out.println("hit userbyname");
        String username = userService.findUsernameByUserid(userid);
        System.out.println(username);
        return "{\"uname\": \"" + username + "\"}";

    }
}
