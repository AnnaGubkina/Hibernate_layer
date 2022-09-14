package com.gubkina.hibernate.homework.hibernate_dao_layer.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Contact implements Serializable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private int age;

}
