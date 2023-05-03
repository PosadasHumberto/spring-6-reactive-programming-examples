package org.hposadas.spring6reactiveexamples.repositories;

import org.hposadas.spring6reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class PersonRepositoryImplFluxErrorHandlingTest {

    PersonRepository personRepository = new PersonRepositoryImpl();

    @Test
    void testFindPersonByIdNotFound() {

        Flux<Person> personFlux = personRepository.findAll();

        final Integer id = 0;

        Mono<Person> personMono = personFlux.filter(p -> p.getId() == id).single()
                        .doOnError(throwable -> {
                            System.out.println("Error occured in flux");
                            System.out.println(throwable.toString());
                        });

        personMono.subscribe(p -> {
            System.out.println(p.toString());
        }, throwable -> {
            System.out.println("Error occurred in the mono");
            System.out.println(throwable.toString());
        });
    }
}