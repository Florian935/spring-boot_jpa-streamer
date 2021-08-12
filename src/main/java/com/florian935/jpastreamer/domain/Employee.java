package com.florian935.jpastreamer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
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

    @OneToMany(
            cascade = ALL,
            orphanRemoval = true,
            fetch = EAGER
    )
    @JoinColumn(name = "employee_id")
    List<Pet> pets = new ArrayList<>();
}
