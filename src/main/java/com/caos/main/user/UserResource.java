package com.caos.main.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		
		User user = userDaoService.findOne(id);
		
		if ( user == null ) {
			throw new UserNotFoundException("id-"+id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user =  userDaoService.deleteById(id);
		
		if (user == null)
			throw new UserNotFoundException("id-"+id);
		
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		
		User savedUser = userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
