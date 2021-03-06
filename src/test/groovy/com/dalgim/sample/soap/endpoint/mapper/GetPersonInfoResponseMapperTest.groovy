package com.dalgim.sample.soap.endpoint.mapper

import com.dalgim.namespace.personservice.general.GetPersonInfoResponse
import com.dalgim.sample.soap.domain.Person
import spock.lang.Specification

/**
 * Created by Mateusz Dalgiewicz on 29.03.2017.
 */
class GetPersonInfoResponseMapperTest extends Specification {

    GetPersonInfoResponseMapper getPersonInfoResponseMapper

    void setup() {
        getPersonInfoResponseMapper = new GetPersonInfoResponseMapper()

    }

    def "should map Person into GetPersonInfoResponse"() {
        given:
            def person = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('xxx')
                    .build()
            person.setId(10l)
        when:
            GetPersonInfoResponse getPersonInfoResponse = getPersonInfoResponseMapper.map(person)
        then:
            getPersonInfoResponseMapper != null
            person.getFirstname() == getPersonInfoResponse.getPersonInfo().getFirstname()
            person.getLastname() == getPersonInfoResponse.getPersonInfo().getLastname()
            person.getLogin() == getPersonInfoResponse.getPersonInfo().getLogin()
            person.getPassword() == getPersonInfoResponse.getPersonInfo().getPassword()
            person.getId() == person.getId()
    }

    def "should return null when PersonDTO is null"() {
        expect:
            getPersonInfoResponseMapper.map(null) == null

    }
}
