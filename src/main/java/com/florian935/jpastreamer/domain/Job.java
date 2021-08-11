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
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "job")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class Job {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "job_id")
    Integer jobId;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "language_id")
    Language language;

    @ManyToMany(cascade = {ALL})
    @JoinTable(
            name = "job_employee",
            joinColumns = {@JoinColumn(name = "job_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    List<Employee> employees = new ArrayList<>();
}
