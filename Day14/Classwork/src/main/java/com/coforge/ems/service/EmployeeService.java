package com.coforge.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coforge.ems.model.Employee;

@Service
public class EmployeeService {
	private List<Employee> list = new ArrayList<>();

	public boolean createEmployee(Employee employee) {
		
		boolean status = list.add(employee);
		//System.out.println(list);
		return status;
	}

	public boolean updateEmployee(Employee employee) {
		
		for(int i = 0 ; i < list.size() ; i++) {
			Employee emp = list.get(i);
			if(emp.getEid() == employee.getEid()) {
				list.remove(i);
				list.add(employee);
				return true;
			}
		}
		
		return false;
	}

	public boolean deleteEmployee(int eid) {
		
		for(int i = 0 ; i < list.size() ; i++) {
			Employee emp = list.get(i);
			if(emp.getEid() == emp.getEid()) {
				list.remove(i);
				return true;
			}
		}
		
		return false;
	}

	public Employee findEmployee(int eid) {
		
		for(int i = 0 ; i < list.size() ; i++) {
			Employee emp = list.get(i);
			if(emp.getEid() == emp.getEid()) {
				return emp;
			}
		}
		return null;
	}

	public List<Employee> findAllEmployee() {
		
		return list;
	}

	
	
}
