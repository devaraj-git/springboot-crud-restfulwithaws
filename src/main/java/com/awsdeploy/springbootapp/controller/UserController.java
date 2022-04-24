package com.awsdeploy.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsdeploy.springbootapp.entity.User;
import com.awsdeploy.springbootapp.exception.ResourceNotFoundException;
import com.awsdeploy.springbootapp.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	// Get All Users
	@GetMapping
	public List<User> getAllUSers(){
		return this.userRepository.findAll();
	}
	// Get User BY Id
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value = "id") long userId) {
		return this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found with id:"+ userId));
	}
	
	// Create User
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	// Update User
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable ("id") long userId) {
		User existingUser = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not found with id" + userId));
				existingUser.setFirstName(user.getFirstName());
				existingUser.setLastName(user.getLastName());
				existingUser.setEmial(user.getEmial());
			return this.userRepository.save(existingUser);
	}
	
	// Delete User
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId){
		User existnguser = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found with id " + userId));
		this.userRepository.delete(existnguser);
		return ResponseEntity.ok().build();
		
	}
		
}
