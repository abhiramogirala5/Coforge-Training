package com.coforge.ems.controller;

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

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

@RestController //It is combination of controller and response body(@Controller + @RestBody)
@RequestMapping("/api/v1/ems")
public class EmployeeController {
	
	private EmployeeService service;
	private Environment environment;
	
	@Autowired  //Constructor Injunction
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this .environment = environment;
		this.service = service;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			boolean status = service.saveEmployee(employee);
			if(status) responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.success"),HttpStatus.CREATED);
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> updateEmployee(@PathVariable("eid") int eid, @RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			boolean status = service.updateEmployee(eid, employee);
			if(status) responseEntity = new ResponseEntity<>(environment.getProperty("ems.update.success"),HttpStatus.CREATED);
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch(EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eid") int eid) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			boolean status = service.deleteEmployeeById(eid);
			if(status) responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"),HttpStatus.CREATED);
		} catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch(EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"),HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/employees/{eid}")
	public ResponseEntity<String> findByEid(@PathVariable("eid") int eid) {
		ResponseEntity<String> responseEntity = null;

		try {
			Optional<Employee> employee = service.findByEid(eid);
			if (employee.isPresent())
				responseEntity = new ResponseEntity<>(employee.get().toString(), HttpStatus.OK);
		}
		catch (InvalidEmployeeObjectException e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"), HttpStatus.BAD_REQUEST);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.db.failed"), HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
}
