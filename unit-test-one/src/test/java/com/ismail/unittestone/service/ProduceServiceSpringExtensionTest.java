package com.ismail.unittestone.service;


import com.ismail.unittestone.UnitTestOneApplication;
import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.repository.ProduceRepository;
import com.ismail.unittestone.service.ProduceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {UnitTestOneApplication.class})
public class ProduceServiceSpringExtensionTest {

    @Autowired
    private ProduceService produceService;

    @MockBean
    private ProduceRepository produceRepository;


    @Test
    public void addProduce() throws Exception {

        Produce p = new Produce("glass", 2000);
        BDDMockito.given(produceRepository.save(p))
                .willReturn(new Produce(1L, "glass", 2000));

        Produce p_f = produceService.add(p);

        p.setId(1L);

        Assertions.assertThat(p_f).isEqualTo(p);
    }


    @Test
    public void getProduce() throws Exception {

        Produce p = new Produce(1L, "glass", 2000);

        BDDMockito.given(produceRepository.findAll())
                .willReturn(Arrays.asList(p));


        List<Produce> p_f = produceService.getAll();

        Assertions.assertThat(p_f).isEqualTo(Arrays.asList(p));
    }


}
