package com.florian935.jpastreamer.dto;

import com.florian935.jpastreamer.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class EmployeeDto {

    Integer employeeId;
    String name;

    public EmployeeDto(Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.name = employee.getName();
    }
}
