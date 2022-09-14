package com.gubkina.hibernate.homework.hibernate_dao_layer.service;

import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import com.gubkina.hibernate.homework.hibernate_dao_layer.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
