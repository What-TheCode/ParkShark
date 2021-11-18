package com.example.parkshark.divisionDataJpaTest;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.address.Address;
import com.example.parkshark.repository.DivisionRepositorySpringData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DivisionRepositorySpringDataTest {
    @Autowired
    private DivisionRepositorySpringData repository;

    Address testAdres =new Address.Builder()
            .withId(1)
            .withStreetName("Vogelzangstraat")
            .withPostalCode(3520)
            .withRegion("Zonhoven")
            .build();
    Person testPerson = new Person("Ralph","Put",testAdres,"0114255","rapit@hotm.com");

    Division testDivision = new Division.Builder()
            .withName("Garage")
            .withOriginalName("Par-Kings")
            .withDirector(testPerson)
            .build();
    @Test
    void servicesAreCool() {
        Assertions.assertNotNull(repository);
    }
}
