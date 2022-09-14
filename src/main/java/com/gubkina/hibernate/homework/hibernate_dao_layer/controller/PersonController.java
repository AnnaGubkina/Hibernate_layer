package com.gubkina.hibernate.homework.hibernate_dao_layer.controller;


import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import com.gubkina.hibernate.homework.hibernate_dao_layer.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return personService.getPersonsByCity(city);
    }
}
