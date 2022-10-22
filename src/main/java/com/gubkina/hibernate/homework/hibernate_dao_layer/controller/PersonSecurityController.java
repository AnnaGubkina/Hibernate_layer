package com.gubkina.hibernate.homework.hibernate_dao_layer.controller;

import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import com.gubkina.hibernate.homework.hibernate_dao_layer.service.PersonService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
public class PersonSecurityController {

    private final PersonService personService;

    public PersonSecurityController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/by-city")
    @Secured({"ROLE_READ"})
    public List<Person> getPersonsByCity(@RequestParam(value = "city", required = false) String city) {
        return personService.getPersonsByCity(city);
    }


    @GetMapping("/persons/by-age")
    @PreAuthorize("hasAnyAuthority('read')")
    public List<Person> getPersonsByAgeLess(@RequestParam(value = "age", required = false) int age) {
        return personService.getPersonsByAgeLess(age);
    }

    @PostMapping("/persons/create")
    @RolesAllowed({"ROLE_WRITE"})
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }


    @DeleteMapping("/persons/delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String deletePerson(@RequestBody Person person) {
        personService.deletePerson(person);
        return "Person with " + person.getContact() + " was deleted";
    }

    @GetMapping("/persons/lk")
    @PreAuthorize("#username == authentication.principal.username")
    public String greetingUser(String username) {
        return "Hello " + username + " from secure app!" ;
    }
}
