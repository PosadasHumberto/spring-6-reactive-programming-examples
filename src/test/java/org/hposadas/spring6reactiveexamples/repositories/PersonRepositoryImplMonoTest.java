package org.hposadas.spring6reactiveexamples.repositories;

import org.hposadas.spring6reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class PersonRepositoryImplMonoTest {

    PersonRepository personRepository = new PersonRepositoryImpl();

    //métodos Mono
    @Test
    void testMonoByIdBlock() {
        Mono<Person> personMono = personRepository.getById(1);

        Person person = personMono.block();

        System.out.println(person);
    }

    @Test
    void testMonoByIdSubscriber() {
        Mono<Person> personMono = personRepository.getById(1);

        personMono.subscribe(p -> {
            System.out.println(p);
        });
    }

    @Test
    void testMapOperation() {
        Mono<Person> personMono = personRepository.getById(1);

        personMono.map(p -> {
            return p.getFirstName();
        }).subscribe(firstName -> {
            System.out.println(firstName);
        });
    }
}