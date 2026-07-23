package com.coforge.dms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.dms.model.Department;

import jakarta.validation.Valid;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	List<Department> findByDname(String dname);

	@Modifying
	int deleteByDname(@Valid String dname);

	@Query("SELECT d.dno FROM Department d")
	List<Integer> getDnos();

}