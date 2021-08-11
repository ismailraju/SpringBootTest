package com.ismail.unittestone.htmlunit;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ismail.unittestone.controller.ProduceController;
import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.service.ProduceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@WebMvcTest(ProduceController.class)
public class MyHtmlUnitTests {


    @Autowired
    private WebClient webClient;

    @MockBean
    private ProduceService produceService;


    @Test
    public void getProduce() throws Exception {
        Produce produce = new Produce(1L, "glass", 2000);


        BDDMockito.given(this.produceService.getAll())
                .willReturn(Arrays.asList(produce));

        Page page = this.webClient.getPage("http://localhost:8080/produce/get");


        Assertions.assertThat(
                page.getWebResponse().getContentAsString())
                .isEqualTo("[{\"id\":1,\"name\":\"glass\",\"price\":2000}]")
        ;


    }


}
