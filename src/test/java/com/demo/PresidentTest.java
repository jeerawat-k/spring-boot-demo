package com.demo;

import com.demo.domain.President;
import com.demo.repository.PresidentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PresidentTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PresidentRepository presidentRepository;

    @Test
    public void saveTest(){
        President president = new President();
        president.setStateBorn("TEST");
        president.setParty("Republic");
        presidentRepository.save(president);
    }
}

