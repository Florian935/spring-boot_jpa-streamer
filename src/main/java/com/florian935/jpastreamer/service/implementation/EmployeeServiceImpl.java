package com.florian935.jpastreamer.service.implementation;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.domain.Employee$;
import com.florian935.jpastreamer.domain.Job;
import com.florian935.jpastreamer.domain.Pet;
import com.florian935.jpastreamer.dto.EmployeeDto;
import com.florian935.jpastreamer.dto.PetDto;
import com.florian935.jpastreamer.repository.EmployeeRepository;
import com.florian935.jpastreamer.service.CrudService;
import com.florian935.jpastreamer.service.EmployeeService;
import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.of;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    JPAStreamer jpaStreamer;

    @Override
    public List<Employee> findAll() {

        return jpaStreamer.stream(Employee.class).toList();
    }

    @Override
    @SneakyThrows
    public Employee findById(Integer id) {

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
    public Employee saveOne(Employee employee) {

        return save(employee);
    }

    @Override
    @SneakyThrows
    public Employee updateOne(Integer id, Employee employee) {

        if (employeeNotExist(id)) {
            throw new Exception("This employee doesn't exist !");
        }

        employee.setEmployeeId(id);

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
                .filter(Employee$.employeeId.in(ids))
                .toList();
    }

    @Override
    public Map<String, List<Employee>> getEmployeesGroupByDepartment() {

        return jpaStreamer.stream(Employee.class)
                .collect(groupingBy(Employee::getDepartment));
    }

    @Override
    public List<Employee> getEmployeesByPage(long pageNumber, long pageSize) {

        return jpaStreamer.stream(Employee.class)
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }

    @Override
    public List<Employee> getEmployeesSortedByName() {

        return jpaStreamer.stream(Employee.class)
                .sorted(Employee$.name)
                .toList();
    }

    @Override
    public List<Employee> getEmployeesSortedByNameThenSalary() {

        return jpaStreamer.stream(Employee.class)
                .sorted(Employee$.name)
                .sorted(Employee$.salary)
                .toList();
    }

    @Override
    public Map<EmployeeDto, List<PetDto>> getPetsGroupByEmployeeIdAndName() {

        return jpaStreamer
                .stream(of(Employee.class).joining(Employee$.pets))
                .collect(
                        toMap(
                                EmployeeDto::new,
                                employee -> employee.getPets()
                                        .stream()
                                        .map(PetDto::new)
                                        .toList())
                );
    }
}