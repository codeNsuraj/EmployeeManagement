package com.employeemanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(service.getAllEmployees());
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {

		if (emp != null) {
			service.saveEmployee(emp);
			return ResponseEntity.ok("Employee with ID " + emp.getId() + " is saved successfully");
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestParam(value = "empid") Integer id) {
		service.deleteEmployee(id);
		return ResponseEntity.ok("Deleted employee associated with ID " + id);
	}

	@GetMapping("/DownloadCSV")
	public void generateCSVForAllEmployees(HttpServletResponse response) {
		service.generateCSVForAllEmployees(response);
	}
}
