package com.florian935.jpastreamer.controller;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1.0/employees")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    Employee saveEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping(path = "/by-name", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    List<Employee> getEmployeesByName(@RequestParam String name) {

        return employeeService.getAllEmployeesByName(name);
    }

    @GetMapping(path = "/by-name/greater-salary", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    List<Employee> getEmployeesByNameAndGreaterSalary(
            @RequestParam String name,
            @RequestParam double salary) {

        return employeeService.getAllEmployeesByNameAndSalary(name, salary);
    }

    @GetMapping(path = "/salary", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    List<Employee> getEmployeesBySalaryRange(
            @RequestParam double minSalary,
            @RequestParam double maxSalary) {

        return employeeService.getEmployeesBySalaryRange(minSalary, maxSalary);
    }

    @SneakyThrows
    @GetMapping(path = "/min-salary", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    Employee getEmployeeWithLessSalary() {

        return employeeService.getEmployeeWithLessSalary();
    }

    @GetMapping(
            path = "by-ids",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(OK)
    List<Employee> getEmployeesByIds(@RequestBody List<Integer> ids) {

        return employeeService.getEmployeesByIds(ids);
    }

    @GetMapping(path = "group-by-department", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    Map<String, List<Employee>> getEmployeeGroupByDepartment() {

        return employeeService.getEmployeeGroupByDepartment();
    }

}
