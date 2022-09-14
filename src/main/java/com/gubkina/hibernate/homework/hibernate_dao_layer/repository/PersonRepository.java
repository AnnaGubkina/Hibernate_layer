package com.gubkina.hibernate.homework.hibernate_dao_layer.repository;

import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.city = :city");
        query.setParameter("city", city);
        List<Person> personsByCity = query.getResultList();

        return personsByCity;
    }
}
