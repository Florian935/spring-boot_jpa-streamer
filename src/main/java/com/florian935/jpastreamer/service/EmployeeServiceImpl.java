package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.domain.Employee$;
import com.florian935.jpastreamer.repository.EmployeeRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
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
    @SneakyThrows
    public Employee getEmployeeById(Integer id) {

        if (employeeNotExist(id)) {
            throw new Exception("This employee doesn't exist !");
        }

        return employeeRepository.findById(id).get();
    }

    private boolean employeeNotExist(Integer id) {

        final Optional<Employee> perhapsEmployee = employeeRepository.findById(id);

        return perhapsEmployee.isEmpty();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return save(employee);
    }

    @Override
    @SneakyThrows
    public Employee updateEmployee(Integer id, Employee employee) {

        if (employeeNotExist(id)) {
            throw new Exception("This employee doesn't exist !");
        }

        employee.setId(id);

        return save(employee);
    }

    private Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    @SneakyThrows
    public void deleteById(Integer id) {

        if (employeeNotExist(id)) {
            throw new Exception("This employee doesn't exist !");
        }

        employeeRepository.deleteById(id);
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

    @Override
    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) {

        return jpaStreamer.stream(Employee.class)
                .filter(Employee$.salary.between(minSalary, maxSalary))
                .toList();
    }

    @Override
    @SneakyThrows
    public Employee getEmployeeWithLessSalary() {

        return jpaStreamer.stream(Employee.class)
                .min(comparing(Employee::getSalary))
                .orElseThrow(() -> new Exception("No employee in database."));
    }

    @Override
    public List<Employee> getEmployeesByIds(List<Integer> ids) {

        return jpaStreamer.stream(Employee.class)
                .filter(Employee$.id.in(ids))
                .toList();
    }

    @Override
    public Map<String, List<Employee>> getEmployeeGroupByDepartment() {

        return jpaStreamer.stream(Employee.class)
                .collect(groupingBy(Employee::getDepartment));
    }

    @Override
    public List<Employee> getEmployeeByPage(long pageNumber, long pageSize) {

        return jpaStreamer.stream(Employee.class)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }
}
