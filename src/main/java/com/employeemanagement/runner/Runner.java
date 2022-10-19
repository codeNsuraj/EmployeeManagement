package com.employeemanagement.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.repo.EmployeeRepo;

@Component
public class Runner implements CommandLineRunner {
	
	private final EmployeeRepo repo;

	public Runner(EmployeeRepo repo) {
		this.repo = repo;
	}

@Override
public void run(String... args) throws Exception {
	List<Employee> emp = new ArrayList<Employee>();
	emp.add(new Employee("John", 120000l));
	emp.add(new Employee("Saurav", 300000l));
	emp.add(new Employee("Nagarjun", 400000l));
	emp.add(new Employee("Vicky", 2800000l));
	emp.add(new Employee("Rocky", 460000l));
	emp.add(new Employee("Rihana", 120000l));
	emp.add(new Employee("Sweta", 3040000l));
	emp.add(new Employee("Manikya", 4400000l));
	emp.add(new Employee("Sanika", 24800000l));
	emp.add(new Employee("Chaitanya", 4604000l));
	repo.saveAll(emp);
	System.out.println("*\n*\n*\nTotal employees present in the database --> "+repo.count()+"\n*\n*\n*");
	
}

}