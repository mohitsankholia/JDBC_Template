package com.mohitsankholia.JdbcTemplate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mohitsankholia.JdbcTemplate.entity.Employee;
import com.mohitsankholia.JdbcTemplate.service.EmpService;

@Service
public class ServiceImpl implements EmpService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveEmployee(Employee employee) {
		
		jdbcTemplate.update("INSERT INTO employee (name, designation, age, salary, city) VALUES(?,?,?,?,?)",
		        new Object[] { employee.getName(), employee.getDesignation(), employee.getAge(), employee.getSalary(), employee.getCity()});
		  }
		

	@Override
	public void updateEmployee(Employee employee) {
		
		jdbcTemplate.update("UPDATE employee SET name=?, designation=? WHERE id=?",
		        new Object[] {  employee.getName(),employee.getDesignation(), employee.getId()});
	}


	@Override
	public void deleteEmployee(Integer id) {
		
		 jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return jdbcTemplate.query("SELECT * from employee", BeanPropertyRowMapper.newInstance(Employee.class));
	}


	@Override
	public Employee getEmployee(Integer id) {
		 return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE ID=?", (rs, rowNum) -> {

	            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"),rs.getInt("age"), rs.getInt("salary"), rs.getString("city"));
	        },id);
	    }


	@Override
	public List<Employee> getByName(String name) {
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE WHERE name=?", (rs, rowNum) -> {

			 return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"),rs.getInt("age"), rs.getInt("salary"), rs.getString("city"));
        },name);		
	}


	@Override
	public List<Employee> getByAge(Integer age) {
		
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE WHERE age=?", (rs, rowNum) -> {

            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"),rs.getInt("age"), rs.getInt("salary"), rs.getString("city"));
        },age);
	}


	@Override
	public List<Employee> getByNameLike(String name) {
		
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE WHERE NAME like ? ",
				new Object[] {"%"+ name + "%"},(rs, rowNum) -> {

		            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"),rs.getInt("age"), rs.getInt("salary"), rs.getString("city"));
		        }) ;
	}


	@Override
	public List<Employee> getBySalaryBetween(Integer startsalary, Integer endsalary) {
		
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE WHERE SALARY BETWEEN ? AND ?",
				new Object[]  { startsalary, endsalary }, (rs, rowNum) -> {

            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"),rs.getInt("age"), rs.getInt("salary"), rs.getString("city"));
        });
	}


	@Override
	public List<Employee> getBySalaryLessThan(Integer salary) {
		
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE WHERE salary<=?", (rs, rowNum) -> {

            return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("designation"),rs.getInt("age"), rs.getInt("salary"), rs.getString("city"));
        },salary);
		
	}
	
	

}
	
	

