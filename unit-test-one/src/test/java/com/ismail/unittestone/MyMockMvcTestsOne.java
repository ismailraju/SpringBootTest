package com.ismail.unittestone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismail.unittestone.model.Produce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MyMockMvcTestsOne {


    @Test
    void addProduct(@Autowired MockMvc mockMvc) throws Exception {

        Produce produce = new Produce("glass", 2000);
        mockMvc.perform(MockMvcRequestBuilders.post("/produce/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(produce))
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("glass"))
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(2000))
        ;


    }

}
