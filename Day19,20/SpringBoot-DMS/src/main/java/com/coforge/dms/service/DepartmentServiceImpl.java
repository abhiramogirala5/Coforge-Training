package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.dms.exception.DepartmentNotFoundException;
import com.coforge.dms.model.Department;
import com.coforge.dms.repo.DepartmentRepo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepo repo;
	private Environment environment;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveDepartment(@NotNull @Valid Department department) {

		repo.save(department);
		return true;
	}

	@Override
	public boolean updateDepartment(@Valid int dno, Department department) {

		if (!repo.existsById(dno)) {
			throw new DepartmentNotFoundException(
					environment.getProperty("dms.invalid.department-notfound"));
		}

		department.setDno(dno);

		repo.save(department);

		return true;
	}

	@Override
	public boolean deleteDepartmentById(@Valid int dno) {

		if (dno > 0) {

			if (!repo.existsById(dno)) {
				throw new DepartmentNotFoundException(
						environment.getProperty("dms.invalid.department-notfound"));
			}

			repo.deleteById(dno);

			return true;
		}

		return false;
	}

	@Override
	public Optional<Department> findByDno(int dno) {

		if (!repo.existsById(dno)) {
			throw new DepartmentNotFoundException(
					environment.getProperty("dms.invalid.department-notfound"));
		}

		return repo.findById(dno);
	}

	@Override
	public List<Department> findAllDepartments() {

		return (List<Department>) repo.findAll();
	}

	@Override
	public List<Department> findByDname(String dname) {

		List<Department> departments = repo.findByDname(dname);

		if (departments.isEmpty()) {
			throw new DepartmentNotFoundException(
					environment.getProperty("dms.invalid.department-notfound"));
		}

		return departments;
	}

	@Override
	@Transactional
	public boolean deleteByDname(@Valid String dname) {

		int n = repo.deleteByDname(dname);

		if (n == 0) {
			throw new DepartmentNotFoundException(
					environment.getProperty("dms.invalid.department-notfound"));
		}

		return true;
	}

	@Override
	public List<Integer> getDnosList() {

		return repo.getDnos();
	}

}