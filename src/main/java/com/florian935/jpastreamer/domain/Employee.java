package com.florian935.jpastreamer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    String department;

    @Column(name = "salary")
    double salary;

    @OneToMany(targetEntity = Pet.class, mappedBy = "employee")
    @JsonIgnoreProperties("employee")
    List<Pet> pets = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "employee_language",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    @JsonIgnoreProperties("employees")
    List<Language> languages = new ArrayList<>();

    @Column(name = "address_id")
    Integer addressId;

    @OneToOne
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    Address address;

    @Column(name = "job_id")
    Integer jobId;

    @ManyToOne(targetEntity = Job.class)
    @JoinColumn(name = "job_id", insertable = false, updatable = false)
    @JsonIgnoreProperties("employees")
    Job job;
}
