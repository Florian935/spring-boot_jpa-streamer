package com.florian935.jpastreamer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class Pet {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "pet_id")
    Integer petId;

    @Column(name = "name")
    String name;
}
