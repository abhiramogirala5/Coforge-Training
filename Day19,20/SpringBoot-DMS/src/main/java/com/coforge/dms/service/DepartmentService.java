package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.dms.model.Department;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface DepartmentService {

	boolean saveDepartment(@NotNull @Valid Department department);

	boolean updateDepartment(@Valid int dno, Department department);

	boolean deleteDepartmentById(@Valid int dno);

	Optional<Department> findByDno(int dno);

	List<Department> findAllDepartments();

	List<Department> findByDname(String dname);

	boolean deleteByDname(@Valid String dname);

	List<Integer> getDnosList();

}