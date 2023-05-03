package org.hposadas.spring6reactiveexamples.repositories;

import org.hposadas.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

    //firmas de métodos
    Mono<Person> getById(Integer Id);

    Flux<Person> findAll();
}
