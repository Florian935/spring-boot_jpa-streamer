package com.florian935.jpastreamer.dto;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.domain.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class JobDto {

    Integer jobId;
    String name;
    List<SimpleEmployeeDto> employees;

    public JobDto(Job job) {

        this.jobId = job.getJobId();
        this.name = job.getName();
        this.employees = fromEmployeeToSimpleEmployeeDto(job.getEmployees());
    }

    private List<SimpleEmployeeDto> fromEmployeeToSimpleEmployeeDto(List<Employee> employees) {

        return employees.stream()
                .map(SimpleEmployeeDto::new)
                .toList();
    }
}
