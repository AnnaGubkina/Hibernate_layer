package com.gubkina.hibernate.homework.hibernate_dao_layer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @EmbeddedId
    private Contact contact;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String phoneNumber;
}
