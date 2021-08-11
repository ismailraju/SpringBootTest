package com.ismail.unittestone.webflux.controller;


import com.gargoylesoftware.htmlunit.WebClient;
import com.ismail.unittestone.controller.ProduceController;
import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.service.ProduceService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;

@WebFluxTest(ProduceReactiveController.class)
//@WebMvcTest(ProduceController.class)
public class MyProductReactiveControllerTests {


    @Autowired
//    @MockBean
    private WebTestClient webTestClient;


    @MockBean
//    @Autowired
    private ProduceService produceService;



    @Test
    public void getProduce() throws Exception {

        Produce produce = new Produce(1L, "glass", 200);


        BDDMockito.given(this.produceService.getAll())
                .willReturn(Arrays.asList(produce));


        this.webTestClient.get().uri("/produce/get")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody(List.class).isEqualTo(Arrays.asList(produce));

    }

}
