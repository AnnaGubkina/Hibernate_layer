package com.gubkina.hibernate.homework.hibernate_dao_layer.service;

import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import com.gubkina.hibernate.homework.hibernate_dao_layer.exception_handling.exceptions.NoSuchPersonException;
import com.gubkina.hibernate.homework.hibernate_dao_layer.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        return personRepository.findPersonByCity(city);
    }

    @Transactional
    public List<Person> getPersonsByAgeLess(int age) {
        return personRepository.findPersonByContactAgeLessThanOrderByContactAge(age);
    }

    @Transactional
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return Optional.ofNullable(personRepository.findPersonByContactNameAndContactSurname(name, surname)
                .orElseThrow(() -> new NoSuchPersonException("There is no Person with name " + name +
                        ", surname " + surname + " in Database")));
    }

    //CRUD

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    public Person getPersonsByContact(String name, String surname, int age) {
        Person personByContact = personRepository.findPersonByContactNameAndContactSurnameAndContactAge(name, surname, age);
        if (personByContact == null) {
            throw new NoSuchPersonException("There is no Person with name " + name +
                    ", surname " + surname + ", age " + age + " in Database");
        }
        return personByContact;
    }

    @Transactional
    public Person updatePersonByContact(Person person) {
        Person personForUpdate = personRepository.findPersonByContact(person.getContact());
        if (personForUpdate == null) {
            throw new NoSuchPersonException("There is no Person with  " + person.getContact() + " in Database");
        }
        personForUpdate.setCity(person.getCity());
        personForUpdate.setPhoneNumber(person.getPhoneNumber());
        return personRepository.save(personForUpdate);
    }

    @Transactional
    public void deletePerson(Person person) {
        Person personFromBD = personRepository.findPersonByContact(person.getContact());
        if (personFromBD == null) {
            throw new NoSuchPersonException("There is no Person  " + person.getContact() + " in Database");
        }
        personRepository.delete(person);
    }
}
