package com.ismail.unittestone.repository;


import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.repository.ProduceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Arrays;
import java.util.List;

@DataJpaTest(showSql = true)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //use 4 real database
public class ProduceRepositoryTest {

    @Autowired
    private ProduceRepository produceRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void addProduce() {

        Produce p = new Produce("glass", 2000);
//        testEntityManager.persistAndFlush(p);
//        testEntityManager.clear();
        produceRepository.save(p);

        Produce p_f = produceRepository.findByName(p.getName());
        p.setId(1L);
        Assertions.assertThat(p_f).isEqualTo(p);

    }


    @Test
    public void getProduce() {

        Produce p1 = new Produce("glass", 2000);
        Produce p2 = new Produce("glass", 2000);
//        testEntityManager.persistAndFlush(p);
//        testEntityManager.clear();
        produceRepository.save(p1);
        produceRepository.save(p2);

        List<Produce> p_f = produceRepository.findAll();
        p1.setId(1L);
        p2.setId(2L);
        Assertions.assertThat(p_f).isEqualTo(Arrays.asList(p1, p2));

    }
}
