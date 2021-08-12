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
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = PRIVATE)
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "address_id")
    Integer addressId;

    @Column(name = "street")
    String street;

    @Column(name = "city")
    String city;

    @Column(name = "zipCode")
    Integer zipCode;
}
