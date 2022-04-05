package com.mohitsankholia.JdbcTemplate.service;

import java.util.List;

import com.mohitsankholia.JdbcTemplate.entity.Employee;

public interface EmpService {

	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	Employee getEmployee(Integer id);
	
	void deleteEmployee(Integer id);
	
	List<Employee> getAllEmployee();
	
	List<Employee> getByName(String name);
	
	List<Employee> getByAge(Integer age);
	
	List<Employee> getByNameLike(String name);
	
	List<Employee> getBySalaryBetween(Integer startsalary, Integer endsalary);
	
	List<Employee> getBySalaryLessThan(Integer salary);
}
