package com.coforge.ems.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ems.model.Employee;

//SpringIOC is responsible for implementation

//public interface EmployeeRepo extends JpaRepository<Employee, Integer> { //Same as DAO

//}

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> { //Same as DAO
	
}
