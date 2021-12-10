package com.zaurtregulov.spring.springboot.spring_data_jpa.service;

import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();

  List<Employee> findAllByName(String name);

  void saveEmployee(Employee employee);

  Employee getEmployeeOrNull(int id);

  void deleteEmployee(int id);

}
