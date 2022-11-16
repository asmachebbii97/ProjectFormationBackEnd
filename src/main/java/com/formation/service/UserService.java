package com.formation.service;

import java.util.List;

import com.formation.entities.User;



public interface UserService {
	    List<User> findAll();
	    void delete(long id);
	    User findOne(String username);
	    User save(User user);
	    User findById(Long id);
	    
}
