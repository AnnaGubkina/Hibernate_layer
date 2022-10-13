package com.gubkina.hibernate.homework.hibernate_dao_layer.repository;

import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Contact;
import com.gubkina.hibernate.homework.hibernate_dao_layer.entity.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


/**
 * This class adds new data and populates the table. To test our application
 */

@Component
public class CommandLineApp implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<String> cities = List.of("Moscow", "New York", "Bangkok", "Paris", "Dubai");
        List<String> names = List.of("Anna", "Vasya", "Olga", "Tomas", "Leo", "Ilon", "Joe", "Grisha", "Gosha");
        List<String> surnames = List.of("Twen", "Mask", "Grey", "Armstrong", "Kim", "Yang", "Listerman");
        Random random = new Random();
        IntStream.range(0, 100)
                .forEach(i -> {
                    Person person = Person.builder()
                            .contact(Contact.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .age(random.nextInt(80))
                                    .build())
                            .city(cities.get(random.nextInt(cities.size())))
                            .phoneNumber("222345" + i)
                            .build();
                    //сохраняем каждого человека в таблицу persons
//                    System.out.println(person);
//                    entityManager.persist(person);

                });

    }
}
