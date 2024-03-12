package com.full.app.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.full.app.Modeles.User;
import com.full.app.Services.UserServiceImpl;



@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/users")
public class UserControler {

	private UserServiceImpl userServiceoimpl;
	
	public UserControler(UserServiceImpl userServiceoimpl ) {
		this.userServiceoimpl= userServiceoimpl;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllusers(){
		return 	new ResponseEntity<>(userServiceoimpl.GetAlluser(),HttpStatus.FOUND);
				
	}
	
	@PostMapping
	public User Adduser(@RequestBody User user) {
		return userServiceoimpl.AddUser(user);
	}
	
	
	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user ,@PathVariable Long id) {
		return userServiceoimpl.UpdateUser(user ,id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable long id) {
		 userServiceoimpl.DeleteUser(id);
	}
	
	
	@GetMapping("/user/{id}")
	public User getuser(@PathVariable long id) {
		return userServiceoimpl.GetUserByid(id);
	}
	
	
	
}
