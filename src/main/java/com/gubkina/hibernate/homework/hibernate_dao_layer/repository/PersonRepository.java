package com.gubkina.hibernate.homework.hibernate_dao_layer.repository;

import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Contact;
import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface PersonRepository  extends JpaRepository<Person, Contact> {


    List<Person> findPersonByCity(String city);

    List<Person> findPersonByContactAgeLessThanOrderByContactAge(int age);

    Optional<Person> findFirstPersonByContactNameAndContactSurname(String name, String surname);

    Person findPersonByContactNameAndContactSurnameAndContactAge(String name, String surname, int age);

    Person findPersonByContact(Contact contact);


}
