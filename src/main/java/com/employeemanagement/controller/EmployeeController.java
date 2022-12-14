package com.employeemanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private final EmployeeServiceImpl service;

	public EmployeeController(EmployeeServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/get")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee emp) {
		service.saveEmployee(emp);
		return "Employee with ID " + emp.getId() + " is saved successfully";
	}

	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam(value = "empid") Integer id) {
		service.deleteEmployee(id);
		return "Deleted employee associated with ID " + id;
	}

	@GetMapping("/DownloadCSV")
	public void generateCSVForAllEmployees(HttpServletResponse response) {
		service.generateCSVForAllEmployees(response);
	}
}
