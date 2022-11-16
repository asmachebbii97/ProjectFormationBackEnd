package com.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.formation.entities.User;
import com.formation.repository.UserRepository;
import com.formation.service.UserService;
import com.formation.controller.UserController;
import com.formation.entities.UserDto;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class UserController {


	private static final Logger logger = LogManager.getLogger(UserController.class);

	  @Autowired
	  private UserRepository userR;
	
	
	  @PreAuthorize("hasRole('ADMIN')")
	    @RequestMapping(value="/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		List<User> pro = userR.findAll();

      return pro;
	    
	}

	@PostMapping("/signup")
	public User createUser(@Valid @RequestBody User user) {
	    return userR.save(user);
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") Long Id) {
	    return userR.findById(Id).orElseThrow(null);
	           // .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    User user = userR.findById(userId).orElseThrow(null);
	            //.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	   // userRepository.deleteById(userId);
	    userR.delete(user);

	    return ResponseEntity.ok().build();
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value = "id") Long Id,
	                                        @Valid @RequestBody User userDetails) {

	    User user =userR.findById(Id).orElseThrow(null);;
	    
	    user.setEmail(userDetails.getEmail());
	    user.setPassword(userDetails.getPassword());
	    user.setFname(userDetails.getFname());
	    user.setLname(userDetails.getLname());
	    user.setImage(userDetails.getImage());
	    
	    User updatedUser = userR.save(user);
	    return updatedUser;
	}
	
	
	}
	
	
	
	
	

