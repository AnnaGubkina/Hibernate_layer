package com.gubkina.hibernate.homework.hibernate_dao_layer.controller;


import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import com.gubkina.hibernate.homework.hibernate_dao_layer.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAgeLess(@RequestParam(value = "age", required = false) int age) {
        return personService.getPersonsByAgeLess(age);
    }

    @GetMapping("/persons/by-name")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam(value = "name", required = false) String name,
                                                     @RequestParam(value = "surname", required = false) String surname) {
        return personService.getPersonByNameAndSurname(name,surname);
    }

    //CRUD
    @PostMapping("/persons/create")
    public Person createPerson(@RequestBody Person person) {
         return personService.createPerson(person);

    }

    @GetMapping("/persons/by-contact")
    public Person getPersonsByContact(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "surname", required = false) String surname,
                                   @RequestParam(value = "age", required = false) int age)  {

        return personService.getPersonsByContact(name,surname,age);
    }

    @PutMapping("/persons/update")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePersonByContact(person);
    }

    @DeleteMapping("/persons/delete")
    public String deletePerson(@RequestBody Person person) {
        personService.deletePerson(person);
        return "Person with " + person.getContact() + " was deleted";
    }

}
