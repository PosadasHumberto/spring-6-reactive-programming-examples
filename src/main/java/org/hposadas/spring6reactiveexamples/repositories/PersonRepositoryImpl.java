package org.hposadas.spring6reactiveexamples.repositories;

import org.hposadas.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

public class PersonRepositoryImpl implements PersonRepository {

    Person humberto = Person.builder()
            .firstName("Humberto")
            .lastName("Posadas")
            .id(1)
            .build();

    Person sophie = Person.builder()
            .firstName("Sophie")
            .lastName("Beccia")
            .id(2)
            .build();

    Person carmelo = Person.builder()
            .firstName("Carmelo")
            .lastName("Anthony")
            .id(3)
            .build();

    Person tracy = Person.builder()
            .firstName("Tracy")
            .lastName("McGrady")
            .id(4)
            .build();

    //métodos
    @Override
    public Mono<Person> getById(final Integer id) {
        return findAll().filter(person -> person.getId() == id)
                .next();    //next devuelve un Mono<Person> si encuentra match o un Mono.empty si no encuentra match
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(humberto, sophie, carmelo, tracy);
    }
}
