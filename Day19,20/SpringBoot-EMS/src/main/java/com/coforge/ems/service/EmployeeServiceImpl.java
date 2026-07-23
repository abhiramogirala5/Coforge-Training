package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ems.dto.DepartmentDTO;
import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;
import com.coforge.ems.service.client.DepartmentClient;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo repo;
	private Environment environment;
	private DepartmentClient client;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo repo,
			Environment environment,
			DepartmentClient client) {

		this.repo = repo;
		this.environment = environment;
		this.client = client;
	}

	@Override
	public boolean saveEmployee(Employee employee) {

		repo.save(employee);
		return true;
	}

	@Override
	public boolean updateEmployee(int eid, Employee employee) {

		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		repo.save(employee);

		return true;
	}

	@Override
	public boolean deleteEmployeeById(int eid) {

		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		repo.deleteById(eid);

		return true;
	}

	@Override
	public Optional<Employee> findByEid(int eid) {

		if (!repo.existsById(eid)) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		return repo.findById(eid);
	}

	@Override
	public List<Employee> findAllEmployees() {

		return (List<Employee>) repo.findAll();
	}

	@Override
	public List<Employee> findByEname(String ename) {

		List<Employee> employees = repo.findByEname(ename);

		if (employees.isEmpty()) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		return employees;
	}

	@Override
	@Transactional
	public boolean deleteByEname(String ename) {

		int n = repo.deleteByEname(ename);

		if (n == 0) {
			throw new EmployeeNotFoundException(
					environment.getProperty("ems.invalid.employee-notfound"));
		}

		return true;
	}

	@Override
	public List<Integer> getEidsList() {

		return repo.getEids();
	}

	@Override
	public String getInfo() {

		return repo.getInfo();
	}

	@Override
	public DepartmentDTO findDepartmentById(int dno) {

		return client.getDepartmentById(dno);
	}

	@Override
	public List<DepartmentDTO> findAllDepartments() {
		List<DepartmentDTO> departments = client.findAllDepartments();
		return departments;
	}

}