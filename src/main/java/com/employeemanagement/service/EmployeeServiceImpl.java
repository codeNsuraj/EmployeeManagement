package com.employeemanagement.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.employeemanagement.controller.EmployeeController;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.exception.DuplicateEmployeeFoundException;
import com.employeemanagement.exception.NoSuchEmloyeeFoundException;
import com.employeemanagement.exception.ResourceNotFound;
import com.employeemanagement.repo.EmployeeRepo;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	private final EmployeeRepo repo;

	public EmployeeServiceImpl(EmployeeRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> findAll = repo.findAll();
		if(!findAll.isEmpty()) {
			log.info("getAllEmployee method from EmployeeServiceImpl class executed successfully");
			return findAll;	
		}
		log.warn("getAllEmployee method from EmployeeServiceImpl class found error beacause employees are not present in DB");
		throw new ResourceNotFound("Database is Empty");
	}

	@Override
	public void saveEmployee(Employee emp) {
		if(repo.findByName(emp.getName())==null) {
			repo.save(emp);
			log.info("saveEmployee method from EmployeeServiceImpl class executed successfully for employee id "+ emp.getId());
		}else {
			log.warn("saveEmployee method from EmployeeServiceImpl class found error beacause employee is present in DB with id "+emp.getId());
			throw new DuplicateEmployeeFoundException(String.format("Employee with name %s is already present in database",emp.getName()));
		}
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.findById(id).orElseThrow(() ->new NoSuchEmloyeeFoundException(String.format("Employee not found with ID %d",id)));
		repo.deleteById(id);
		log.info("deleteEmployee method from EmployeeServiceImpl class executed successfully for employee id "+id);
	}
	
	@Override
	public void generateCSVForAllEmployees(HttpServletResponse response) {
		
		List<Employee> allEmployees = getAllEmployees();
		String filename = "Employees.csv";
		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
		StatefulBeanToCsv<Employee> writer;
		try {
			writer = new StatefulBeanToCsvBuilder<Employee>(response.getWriter())
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.withOrderedResults(true).build();
			writer.write(allEmployees);
		} catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			log.error("generateCSVForAllEmployees method from EmployeeServiceImpl class found error beacause of "+e.getMessage());
			e.printStackTrace();
		}
	}

}
