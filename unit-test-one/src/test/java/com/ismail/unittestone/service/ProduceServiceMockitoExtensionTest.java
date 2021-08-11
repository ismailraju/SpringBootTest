package com.ismail.unittestone.service;


import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.repository.ProduceRepository;
import com.ismail.unittestone.service.ProduceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ProduceServiceMockitoExtensionTest {

    @InjectMocks
    private ProduceService produceService;

    @Mock
    private ProduceRepository produceRepository;


    @BeforeEach
    public void setUp() throws Exception {
        produceService = new ProduceService(produceRepository);
    }

    @Test
    public void addProduce() throws Exception {

        Produce p = new Produce("glass", 2000);
        BDDMockito.given(produceRepository.save(p))
                .willReturn(new Produce(1L, "glass", 2000));

        Produce p_f = produceService.add(p);

        p.setId(1L);

        Assertions.assertThat(p_f).isEqualTo(p);
    }


}
