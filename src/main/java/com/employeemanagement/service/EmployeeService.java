package com.employeemanagement.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.employeemanagement.entity.Employee;

public interface EmployeeService {
	
	//get
	public List<Employee> getAllEmployees();
	
	//save
	public void saveEmployee(Employee emp);
	
	//delete
	public void deleteEmployee(Integer id);
	
	//GenerateCSV
	void generateCSVForAllEmployees(HttpServletResponse response);

}
