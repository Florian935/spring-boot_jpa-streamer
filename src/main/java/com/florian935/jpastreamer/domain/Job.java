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

    @OneToMany(targetEntity = Employee.class, mappedBy = "job")
    @JsonIgnoreProperties("job")
    List<Employee> employees = new ArrayList<>();
}
