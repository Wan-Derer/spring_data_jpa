package com.zaurtregulov.spring.springboot.spring_data_jpa.controller;

import com.zaurtregulov.spring.springboot.spring_data_jpa.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_data_jpa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class MyController {

  final private EmployeeService employeeService;

  @GetMapping("/ok")
  public String printOk() {

    return ">>>>>>>>>>> OK (всё хорошо!)";
  }

  @GetMapping("/employees")
  public List<Employee> showEmployees(@RequestParam(required = false, name = "name") String name) {
    System.out.println(">>>>>>>>>>>>>> " + name);

    List<Employee> allEployees = name != null ?
      employeeService.findAllByName(name) :
      employeeService.findAll()
      ;

    return allEployees;
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable int id) {

    Employee emp = employeeService.getEmployeeOrNull(id);

//    if (emp == null) throw new NoSuchEmployeeException("Нет сотрудника с ID = " + id);

    return emp;
  }

  @GetMapping("/employees/name/{name}")
  public List<Employee> getEmployeeByName(@PathVariable String name) {

    List<Employee> emps = employeeService.findAllByName(name);

//    if (emp == null) throw new NoSuchEmployeeException("Нет сотрудника с ID = " + id);

    return emps;
  }

  @PostMapping("/employees")
  public Employee addNewEmployee(@RequestBody Employee employee){

    employeeService.saveEmployee(employee);
    System.out.println(employee);
    return employee;
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee){

    employeeService.saveEmployee(employee);

    return employee;
  }

  @DeleteMapping(value = "/employees/{id}", produces = "text/html; charset=utf-8")
  public String deleteEmployee(@PathVariable int id) {

    Employee emp = employeeService.getEmployeeOrNull(id);

   // if (emp == null) throw new NoSuchEmployeeException("Нет сотрудника с ID = " + id);

    employeeService.deleteEmployee(id);

    return "Сотрудник " + emp.getSurname() + " погорел";
  }




}
