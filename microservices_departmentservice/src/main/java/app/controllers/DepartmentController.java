package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Department;
import app.services.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentService service;

	// CREATE
	@PostMapping("/department")
	public ResponseEntity<?> addDepartment(@RequestBody Department department) {
		try {
			Department d = service.saveDepartment(department);
			return new ResponseEntity<Department>(d, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Can't add department - invalid entry", HttpStatus.CONFLICT);
		}
	}

	// READ
	@GetMapping("/department/{id}")
	public ResponseEntity<?> getDepartment(@PathVariable("id") int departmentId) {
		Optional<Department> d = Optional.ofNullable(service.fetchDepartment(departmentId));
		if (d.isPresent()) {
			return new ResponseEntity<Department>(d.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>("such department does not exist", HttpStatus.NO_CONTENT);
		}
	}

	// UPDATE
	@PutMapping("/department/{id}")
	public ResponseEntity<?> updateDepartment(@RequestBody Department department,
			@PathVariable("id") int departmentId) {
		Optional<Department> dpt = Optional.ofNullable(service.updateDepartment(department, departmentId));
		if (dpt.isPresent())
			return new ResponseEntity<>(dpt.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>("such department does not exist", HttpStatus.BAD_REQUEST);
	}

	// DELETE
	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") int departmentId) {
		String msg = service.deleteDepartment(departmentId);
		int code = msg.toLowerCase().contains("success") ? 202 : 410;
		return new ResponseEntity<>(msg, HttpStatusCode.valueOf(code));
	}

	// READ
	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartment() {
		List<Department> d = service.fetchAllDepartments();
		return new ResponseEntity<>(d, HttpStatus.ACCEPTED);
	}

	@PostMapping("/departments")
	public ResponseEntity<?> saveAllDepartment(@RequestBody List<Department> departments) {
		try {
			List<Department> d = service.saveAllDepartments(departments);
			return new ResponseEntity<>(d, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Can't add departments - invalid entries", HttpStatus.CONFLICT);
		}
	}

}
