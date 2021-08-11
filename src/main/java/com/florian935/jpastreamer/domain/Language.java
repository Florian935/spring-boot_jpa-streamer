package com.florian935.jpastreamer.domain;

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

    @OneToMany(mappedBy = "language", fetch = EAGER)
    List<Job> jobs = new ArrayList<>();
}
