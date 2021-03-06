package com.dalgim.sample.soap.mapper;

import com.dalgim.sample.soap.domain.Person;
import com.dalgim.sample.soap.entity.PersonEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Dalgiewicz on 25.03.2017.
 */
@Component
public class PersonMapper implements ObjectMapper<Person, PersonEntity> {

    @Override
    public Person map(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }

        return Person.builder()
                .id(personEntity.getId())
                .firstname(personEntity.getFirstname())
                .lastname(personEntity.getLastname())
                .login(personEntity.getLogin())
                .password(personEntity.getPassword())
                .build();
    }

    @Override
    public PersonEntity reverseMap(Person person) {
        if (person == null) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstname(person.getFirstname());
        personEntity.setLastname(person.getLastname());
        personEntity.setLogin(person.getLogin());
        personEntity.setPassword(person.getPassword());
        return personEntity;
    }
}
