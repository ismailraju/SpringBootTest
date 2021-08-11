package com.ismail.unittestone.controlerServiceRepo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismail.unittestone.controller.ProduceController;
import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.repository.ProduceRepository;
import com.ismail.unittestone.service.ProduceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@WebMvcTest(ProduceController.class)
//@ExtendWith(SpringExtension.class)
//@DataJpaTest(showSql = true)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProduceControllerServiceRepo {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProduceService produceService;

    @Autowired
    private ProduceRepository produceRepository;


    @Test
    public void addProduct() throws Exception {

        Produce produce = new Produce("glass", 200);

        produceService.add(produce);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/produce/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(produce))
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("glass"))
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(200))
        ;

    }


}
