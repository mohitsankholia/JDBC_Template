package com.mohitsankholia.JdbcTemplate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",nullable = false,length = 200)
	private String name;
	
	@Column(name="designation",nullable = false,length = 200)
	private String Designation;
	
	private Integer salary , age;
	private String city;

}