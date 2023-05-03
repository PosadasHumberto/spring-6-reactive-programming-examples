package org.hposadas.spring6reactiveexamples.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    //atributos
    private Integer id;
    private String firstName;
    private String lastName;

}
