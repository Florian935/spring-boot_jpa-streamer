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
@Table(name = "language")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Builder
public class Language {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "language_id")
    Integer languageId;

    @Column(name = "name")
    String name;

    @ManyToMany
    @JoinTable(
            name = "employee_language",
            joinColumns = @JoinColumn(name = "language_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @JsonIgnoreProperties("languages")
    List<Employee> employees = new ArrayList<>();
}
