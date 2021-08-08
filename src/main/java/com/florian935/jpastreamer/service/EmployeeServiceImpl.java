package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.domain.Employee$;
import com.florian935.jpastreamer.repository.EmployeeRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    JPAStreamer jpaStreamer;

    @Override
    public List<Employee> getAllEmployees() {

        return jpaStreamer.stream(Employee.class).toList();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployeesByName(String name) {

        return jpaStreamer.stream(Employee.class)
                .filter(Employee$.name.equal(name))
                .toList();
    }

    @Override
    public List<Employee> getAllEmployeesByNameAndSalary(String name, double salary) {

        return jpaStreamer.stream(Employee.class)
                .filter(Employee$
                        .name.equal(name)
                        .and(Employee$.salary.greaterThan(salary)))
                .toList();
    }


}
