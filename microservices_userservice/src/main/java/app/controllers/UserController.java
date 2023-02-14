package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.VO.ResultVO;
import app.entity.User;
import app.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;

	// CREATE
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			User d = service.saveDepartment(user);
			return new ResponseEntity<User>(d, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Can't add user - invalid entry" + e, HttpStatus.CONFLICT);
		}
	}

	// READ
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") int userId) {
		Optional<ResultVO> d = Optional.ofNullable(service.fetchUser(userId));
		if (d.isPresent()) {
			return new ResponseEntity<>(d.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("User does not exist", HttpStatus.NO_CONTENT);
		}
	}

	// READ
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		List<ResultVO> d = service.fetchAllUsers();
		return new ResponseEntity<>(d, HttpStatus.ACCEPTED);
	}

	// UPDATE
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") int userId) {
		User d = service.updateUser(user, userId);
		return new ResponseEntity<>(d, HttpStatus.ACCEPTED);
	}

	// DELETE
	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteDepartment(@PathVariable("id") int userId) {
		Optional<User> user = Optional.ofNullable(service.deleteUser(userId));
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
		}

	}
}
