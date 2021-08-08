package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Employee;
import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {

    JPAStreamer jpaStreamer;

    @Override
    public List<Employee> getAllEmployees() {

        return jpaStreamer.stream(Employee.class).toList();
    }
}
