package com.dao;

import java.util.List;

import com.model.Employee;


public interface EmployeeDAO {
	
	int saveEmployee(Employee emp);
	int deleteEmployee(Employee emp);
	int deleteEmployeebyID(int id);
	
	int updateEmployee(Employee emp);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(int id);
	
	
}
