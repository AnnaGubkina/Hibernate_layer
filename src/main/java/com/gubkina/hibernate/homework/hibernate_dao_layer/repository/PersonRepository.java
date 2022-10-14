package com.gubkina.hibernate.homework.hibernate_dao_layer.repository;

import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Contact;
import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Contact> {

    @Query("select p from Person p where p.city = :city")
    List<Person> findPersonByCity(@Param("city") String city);

    @Query("select p from Person p where p.contact.age < :age order by p.contact.age asc")
    List<Person> findPersonByContactAgeLessThanOrderByContactAge(@Param("age") int age);

    @Query("select p from Person p where p.contact.name = :name and p.contact.surname = :surname ")
    Optional<Person> findPersonByContactNameAndContactSurname(String name, String surname);

    @Query("select p from Person p where p.contact.name = :name and p.contact.surname = :surname and p.contact.age = :age")
    Person findPersonByContactNameAndContactSurnameAndContactAge(String name, String surname, int age);

    @Query("select p from Person p where p.contact = :contact")
    Person findPersonByContact(Contact contact);

}
