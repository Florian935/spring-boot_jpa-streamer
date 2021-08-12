package com.florian935.jpastreamer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_id")
    Integer employeeId;

    @Column(name = "name")
    String name;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private double salary;

    @OneToMany(targetEntity = Pet.class, mappedBy = "employee")
    @JsonIgnoreProperties("employee")
    List<Pet> pets = new ArrayList<>();
}
