package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.domain.Pet;
import com.florian935.jpastreamer.dto.EmployeeDto;
import com.florian935.jpastreamer.dto.PetDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService extends CrudService<Employee, Integer> {

    List<Employee> getAllEmployeesByName(String name);

    List<Employee> getAllEmployeesByNameAndSalary(String name, double salary);

    List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary);

    Employee getEmployeeWithLessSalary();

    List<Employee> getEmployeesByIds(List<Integer> ids);

    Map<String, List<Employee>> getEmployeesGroupByDepartment();

    List<Employee> getEmployeesByPage(long pageNumber, long pageSize);

    List<Employee> getEmployeesSortedByName();

    List<Employee> getEmployeesSortedByNameThenSalary();

    Map<EmployeeDto, List<PetDto>> getPetsGroupByEmployeeIdAndName();
}
