package com.ismail.unittestone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismail.unittestone.model.Produce;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitTestOneApplicationTests {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getStaticProduct(@Autowired TestRestTemplate testRestTemplate) throws Exception {

        Produce produce = new Produce(1L, "glass", 2000);

        Produce p_f = testRestTemplate
                .getForObject("/produce/get-static", Produce.class);
        Assertions.assertThat(p_f).isEqualTo(produce);

    }


    @Test
    void addProduce() throws Exception {

        Produce p1 = new Produce("glass", 2000);
        Produce p2 = new Produce("glass", 2000);

        Produce p_f1 = testRestTemplate.postForObject("/produce/add", p1, Produce.class);
        Produce p_f2 = testRestTemplate.postForObject("/produce/add", p2, Produce.class);

        List<Produce> p_all = testRestTemplate.getForObject("/produce/get", List.class);

        Assertions.assertThat(new ObjectMapper().writeValueAsString(p_all)).isEqualTo(new ObjectMapper().writeValueAsString(Arrays.asList(p_f1, p_f2)));

    }


}
