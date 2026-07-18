package com.coforge.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.repo.EmployeeRepo;

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

}
