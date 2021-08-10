package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployeesByName(String name);

    List<Employee> getAllEmployeesByNameAndSalary(String name, double salary);

    List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary);

    Employee getEmployeeWithLessSalary();

    List<Employee> getEmployeesByIds(List<Integer> ids);

    Map<String, List<Employee>> getEmployeeGroupByDepartment();
}
