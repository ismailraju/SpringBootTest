package com.ismail.unittestone.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismail.unittestone.controller.ProduceController;
import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.service.ProduceService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;

@WebMvcTest(ProduceController.class)
public class ProduceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProduceService produceService;


    @Test
    public void addProduct() throws Exception {

        Produce produce = new Produce(1L,"glass", 2000);

        BDDMockito.given(this.produceService.add(produce))
                .willReturn(new Produce(1L, "glass", 2000));

        mockMvc.perform(
                MockMvcRequestBuilders.post("/produce/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(produce))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("glass"))
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(2000))
        ;

    }

    @Test
    public void addProduct2() throws Exception {

        Produce produce = new Produce(1L,"glass", 2000);

        BDDMockito.given(this.produceService.add(produce))
                .willReturn(new Produce(1L, "glass", 2000));

        mockMvc
                .perform(MockMvcRequestBuilders.post("/produce/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(produce))
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Produce(1L, "glass", 2000))))
        ;


    }

    @Test
    public void getProduct() throws Exception {

        Produce produce1 = new Produce(1L, "glass", 2000);
        Produce produce2 = new Produce(2L, "glass", 2000);


        BDDMockito.given(this.produceService.getAll())
                .willReturn(Arrays.asList(produce1, produce2));


        mockMvc
                .perform(MockMvcRequestBuilders.get("/produce/get")
                        .accept(MediaType.APPLICATION_JSON)

                )
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(Arrays.asList(produce1, produce2))))

        ;


    }


    @Test
    public void getProduct2() throws Exception {

        Produce produce = new Produce("glass", 2000);

        BDDMockito.given(this.produceService.getAll())
                .willReturn(Arrays.asList(new Produce(1L, "glass", 2000)));

        mockMvc
                .perform(MockMvcRequestBuilders.get("/produce/get")

                )
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":1,\"name\":\"glass\",\"price\":2000}]"));


    }
}
