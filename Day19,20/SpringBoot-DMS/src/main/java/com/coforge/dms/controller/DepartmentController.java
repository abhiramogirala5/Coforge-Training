package com.coforge.dms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import com.coforge.dms.model.Department;
import com.coforge.dms.service.DepartmentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/dms")
public class DepartmentController {

	private DepartmentService service;
	private Environment environment;

	@Autowired
	public DepartmentController(DepartmentService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/departments")
	public ResponseEntity<String> saveDepartment(
			@NotNull @Valid @RequestBody Department department) {

		boolean status = service.saveDepartment(department);

		if (status) {
			return new ResponseEntity<>(
					environment.getProperty("dms.save.success"),
					HttpStatus.CREATED);
		}

		return null;
	}

	@PutMapping("/departments/{dno}")
	public ResponseEntity<String> updateDepartment(
			@PathVariable("dno") int dno,
			@RequestBody Department department) {

		boolean status = service.updateDepartment(dno, department);

		if (status) {
			return new ResponseEntity<>(
					environment.getProperty("dms.update.success"),
					HttpStatus.CREATED);
		}

		return null;
	}

	@DeleteMapping("/departments/{dno}")
	public ResponseEntity<String> deleteDepartment(
			@PathVariable("dno") int dno) {

		boolean status = service.deleteDepartmentById(dno);

		if (status) {
			return new ResponseEntity<>(
					environment.getProperty("dms.delete.success"),
					HttpStatus.OK);
		}

		return null;
	}

	@GetMapping("/departments/{dno}")
	public ResponseEntity<Department> findByDno(@PathVariable("dno") int dno) {

		Optional<Department> department = service.findByDno(dno);

		if (department.isPresent()) {
			return new ResponseEntity<>(department.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/departments")
	public ResponseEntity<?> findAllDepartments() {

		List<Department> departments = service.findAllDepartments();

		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@GetMapping("/departments/dname/{dname}")
	public ResponseEntity<?> findByDname(
			@PathVariable("dname") String dname) {

		List<Department> departments = service.findByDname(dname);

		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@DeleteMapping("/departments/dname/{dname}")
	public ResponseEntity<?> deleteByDname(
			@PathVariable("dname") String dname) {

		boolean status = service.deleteByDname(dname);

		if (status) {
			return new ResponseEntity<>(
					environment.getProperty("dms.delete.success"),
					HttpStatus.OK);
		}

		return null;
	}

	@GetMapping("/departments/dnos")
	public ResponseEntity<?> getDnosList() {

		List<Integer> dnos = service.getDnosList();

		return new ResponseEntity<>(dnos, HttpStatus.OK);
	}

}