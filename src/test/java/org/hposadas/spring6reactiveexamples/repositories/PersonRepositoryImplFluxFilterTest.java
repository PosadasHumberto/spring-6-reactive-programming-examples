package org.hposadas.spring6reactiveexamples.repositories;

import org.hposadas.spring6reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class PersonRepositoryImplFluxFilterTest {

    PersonRepository personRepository = new PersonRepositoryImpl();


    @Test
    void testFilterOnName() {
        personRepository.findAll()
                .filter(p -> p.getFirstName().equalsIgnoreCase("carmelo"))
                .subscribe(p -> System.out.println(p));
    }

    @Test
    void testGetById() {
        Mono<Person> tracyMono = personRepository.findAll()
                .filter(p -> p.getFirstName().equalsIgnoreCase("tracy")).next();

        tracyMono.subscribe(person -> System.out.println(person.getFirstName()));
    }

    @Test
    void testGetByIdFound() {
        Mono<Person> personMono = personRepository.getById(1);

        assertTrue(personMono.hasElement().block());
    }

    @Test
    void testGetByIdNotFound() {
        Mono<Person> personMono = personRepository.getById(6);

        assertFalse(personMono.hasElement().block());
    }
}