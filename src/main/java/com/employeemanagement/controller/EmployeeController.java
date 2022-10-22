package com.employeemanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	private final EmployeeServiceImpl service;

	public EmployeeController(EmployeeServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		log.info("/emp/get method excecuted successfully");
		return ResponseEntity.ok(service.getAllEmployees());
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		service.saveEmployee(emp);
		log.info("/emp/save method excecuted successfully");
		return ResponseEntity.ok("Employee with ID " + emp.getId() + " is saved successfully");
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestParam(value = "empid") Integer id) {
		service.deleteEmployee(id);
		log.info("/emp/delete method excecuted successfully with id "+id);
		return ResponseEntity.ok("Deleted employee associated with ID " + id);
	}

	@GetMapping("/DownloadCSV")
	public void generateCSVForAllEmployees(HttpServletResponse response) {
		service.generateCSVForAllEmployees(response);
	}
}
