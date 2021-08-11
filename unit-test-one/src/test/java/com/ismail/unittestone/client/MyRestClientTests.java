package com.ismail.unittestone.client;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.service.ProduceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

@RestClientTest(ProduceService.class)
public class MyRestClientTests {

    @Autowired
    private ProduceService produceService;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;


    @Test
    public void getProduce() throws Exception{

//        Produce produce = new Produce(1L,"glass", 2000);
//        this.mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("/produce/get-static"))
//                .andRespond(MockRestResponseCreators.withSuccess(new ObjectMapper().writeValueAsString(produce), MediaType.APPLICATION_JSON));
//
//
//        String greeting = this.produceService.callRestService();
//        Assertions.assertThat(greeting).isEqualTo("hello");


    }
}
