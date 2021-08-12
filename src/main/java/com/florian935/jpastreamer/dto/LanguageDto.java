package com.florian935.jpastreamer.dto;

import com.florian935.jpastreamer.domain.Employee;
import com.florian935.jpastreamer.domain.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder
public class LanguageDto {

    Integer languageId;
    String name;
    List<SimpleEmployeeDto> employees;

    public LanguageDto(Language language) {

        this.languageId = language.getLanguageId();
        this.name = language.getName();
        this.employees = fromEmployeeToEmployeeDto(language.getEmployees());
    }

    private List<SimpleEmployeeDto> fromEmployeeToEmployeeDto(List<Employee> employees) {

        return employees
                .stream()
                .map(SimpleEmployeeDto::new)
                .toList();
    }
}
