package com.mohitsankholia.JdbcTemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohitsankholia.JdbcTemplate.entity.Employee;
import com.mohitsankholia.JdbcTemplate.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {
	
	@Autowired
	private EmpService empservice;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
		
		empservice.saveEmployee(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		
		empservice.updateEmployee(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/getbyid")
	public ResponseEntity<Object> getEmployee(@RequestParam Integer id) {
		
		Employee employee = empservice.getEmployee(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
    
	
	@DeleteMapping("/deletebyid")
	public ResponseEntity<Object> deleteEmployee(@RequestParam Integer id) {
		
		empservice.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<Object> getAllEmployee() {
		
		List<Employee> employee = empservice.getAllEmployee();
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbyname")
	public ResponseEntity<Object> getByName(@RequestParam String name) {
		
		List<Employee> employee = empservice.getByName(name);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbyage")
	public ResponseEntity<Object> getByAge(@RequestParam Integer age) {
		
		List<Employee> employee = empservice.getByAge(age);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbynamelike")
	public ResponseEntity<Object> getByNameLike(@RequestParam String name) {
		
		List<Employee> employee = empservice.getByNameLike(name);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbysalarybetween")
	public ResponseEntity<Object> getBySalaryBetween(@RequestParam Integer startsalary, Integer endsalary) {
		
		List<Employee> employee = empservice.getBySalaryBetween(startsalary, endsalary);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getbysalarylessthan")
	public ResponseEntity<Object> getBySalaryLessThan(@RequestParam Integer salary) {
		
		List<Employee> employee = empservice.getBySalaryLessThan(salary);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}

}
