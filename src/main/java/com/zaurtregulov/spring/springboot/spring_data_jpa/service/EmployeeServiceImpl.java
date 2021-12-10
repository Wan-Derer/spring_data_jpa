package com.zaurtregulov.spring.springboot.spring_data_jpa.service;

import com.zaurtregulov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public void saveEmployee(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  public Employee getEmployeeOrNull(int id) {
    return employeeRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteEmployee(int id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public List<Employee> findAllByName(String name) {
    return employeeRepository.findAllByName(name);
  }


}
