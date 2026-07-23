package com.coforge.ems.controller;

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

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.dto.EmployeeDTO;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;

import jakarta.validation.Valid;

@RestController // It is combination of controller and response body(@Controller + @RestBody)
@RequestMapping("/api/v1/ems")
public class EmployeeController {

	private EmployeeService service;
	private Environment environment;
	

	@Autowired // Constructor Injunction
	public EmployeeController(EmployeeService service, Environment environment) {
		super();
		this.environment = environment;
		this.service = service;
	}

	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.saveEmployee(employee);
		if (status)
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.save.success"), HttpStatus.CREATED);

		return responseEntity;
	}

	@PutMapping("/employees/{eid}")
	public ResponseEntity<String> updateEmployee(@Valid @PathVariable("eid") int eid, @RequestBody Employee employee) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.updateEmployee(eid, employee);
		if (status)
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.update.success"), HttpStatus.CREATED);

		return responseEntity;
	}

	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<String> deleteEmployee(@Valid @PathVariable("eid") int eid) {
		ResponseEntity<String> responseEntity = null;

		boolean status = service.deleteEmployeeById(eid);
		if (status)
			responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.CREATED);

		return responseEntity;
	}

	@GetMapping("/employees/{eid}")
	public ResponseEntity<?> findByEid(@PathVariable("eid") int eid) {
		ResponseEntity<String> responseEntity = null;

		Optional<Employee> employee = service.findByEid(eid);
		if (employee.isPresent())
			return ResponseEntity.ok(employee);

		return responseEntity;
	}

	@GetMapping("/employees")
	public ResponseEntity<?> findAllEmployees() {
		ResponseEntity<?> responseEntity = null;

		List<Employee> employees = service.findAllEmployees();
		responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/employees/ename/{ename}")
	public ResponseEntity<?> findByEname(@Valid @PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;

		List<Employee> employees = service.findByEname(ename);
		responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);

		return responseEntity;
	}

	@DeleteMapping("/employees/ename/{ename}")
	public ResponseEntity<?> deleteByEname(@Valid @PathVariable("ename") String ename) {
		ResponseEntity<?> responseEntity = null;

		boolean status = service.deleteByEname(ename);
		responseEntity = new ResponseEntity<>(environment.getProperty("ems.delete.success"), HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/employees/eids")
	public ResponseEntity<?> getEidsList() {
		ResponseEntity<?> responseEntity = null;

		List<Integer> eids = service.getEidsList();
		responseEntity = new ResponseEntity<>(eids, HttpStatus.OK);

		return responseEntity;
	}

	@GetMapping("/employees/info")
	public ResponseEntity<?> getInfo() {
		ResponseEntity<?> responseEntity = null;

		String info = service.getInfo();
		responseEntity = new ResponseEntity<>(info, HttpStatus.OK);

		return responseEntity;
	}
	
	//Rest End Points for Feign Client Department
	@GetMapping("/employees/departments/{dno}")
	public ResponseEntity<?> findDepartmentById(@PathVariable int dno) {
		ResponseEntity<?> responseEntity = null;
		DepartmentDTO department = service.findDepartmentById(dno);
		if(department != null)
			responseEntity = new ResponseEntity<>(department,HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<>("FAILED : Department Not Found",HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
	@GetMapping("/employees/departments")
	public ResponseEntity<List<DepartmentDTO>> findAllDepartments() {
		ResponseEntity<List<DepartmentDTO>> responseEntity = null;
		List<DepartmentDTO> departments = service.findAllDepartments();
		
			responseEntity = new ResponseEntity<>(departments,HttpStatus.OK);
		
			
		return responseEntity;
	}
	
	@GetMapping("/employees/{eid}/departments")
	public ResponseEntity<EmployeeDTO> findEmployeeDetails(@PathVariable("eid") int eid) {
		ResponseEntity<EmployeeDTO> responseEntity = null;
		
		EmployeeDTO employeeDto = new EmployeeDTO();
		Employee employee = service.findByEid(eid).get();
		DepartmentDTO department = service.findDepartmentById(employee.getdno());
		
		employeeDto.setEmployee(employee);
		employeeDto.setDepartment(department);
		responseEntity = new ResponseEntity<>(employeeDto, HttpStatus.OK);

		return responseEntity;
	}

}
