package com.coforge.ems.service;

import java.util.Optional;

import com.coforge.ems.exception.EmployeeNotFoundException;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;


public interface EmployeeService {

	public boolean saveEmployee(Employee employee) throws InvalidEmployeeObjectException;

	public boolean updateEmployee(int eid , Employee employee) throws InvalidEmployeeObjectException , EmployeeNotFoundException;

	public boolean deleteEmployeeById(int eid)throws InvalidEmployeeObjectException , EmployeeNotFoundException;
		
	public Optional<Employee> findByEid(int eid) throws EmployeeNotFoundException, InvalidEmployeeObjectException;
}
