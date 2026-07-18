package com.coforge.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepo repo;
	
	@Autowired //Constructor Injunction
	public EmployeeServiceImpl(EmployeeRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public boolean saveEmployee(Employee employee) throws InvalidEmployeeObjectException {
		// TODO Auto-generated method stub
		
		if(employee != null && employee.getEid() > 0 && employee.getEname() != null && employee.getEsalary() > 0 && employee.getdno() > 0) {
			repo.save(employee);
			return true;
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public boolean updateEmployee(int eid, Employee employee) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		
		if(eid > 0 && employee != null && employee.getEid() > 0 && employee.getEname() != null && employee.getEsalary() > 0 && employee.getdno() > 0) {
			if(!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			repo.save(employee); //save performs insert as well as update
			return true;
		} else {
			throw new InvalidEmployeeObjectException();
		}
		
	}

	@Override
	public boolean deleteEmployeeById(int eid) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		if(eid > 0) {
			if(!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			repo.deleteById(eid);
			return true;
		}
		
		
		return false;
		
	}

	@Override
	public Optional<Employee> findByEid(int eid) throws EmployeeNotFoundException, InvalidEmployeeObjectException {
		if (eid > 0) {
			if(!repo.existsById(eid)) {
				throw new EmployeeNotFoundException();
			}
			Optional<Employee> employee = repo.findById(eid);
			return employee;
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees = (List<Employee>) repo.findAll();
		return employees;
	}

	@Override
	public List<Employee> findByEname(String ename) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		if (ename != null) {
			List<Employee> employees = repo.findByEname(ename);
			if (employees.isEmpty()) {
				throw new EmployeeNotFoundException();
			}
			return employees;
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	@Transactional
	public boolean deleteByEname(String ename) throws InvalidEmployeeObjectException, EmployeeNotFoundException {
		if (ename != null) {
			int n = repo.deleteByEname(ename);
			if(n == 0) {
				throw new EmployeeNotFoundException();
			}
			return true;
		} else {
			throw new InvalidEmployeeObjectException();
		}
	}

	@Override
	public List<Integer> getEidsList() {
		List<Integer> eids = repo.getEids();
		return eids;
	}

	@Override
	public String getInfo() {
		return repo.getInfo();
	}

}
