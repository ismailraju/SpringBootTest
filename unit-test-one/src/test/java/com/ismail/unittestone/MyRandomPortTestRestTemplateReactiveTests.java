package com.ismail.unittestone;

import com.ismail.unittestone.model.Produce;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyRandomPortTestRestTemplateReactiveTests {


    @Test
    void getStaticProduct(@Autowired TestRestTemplate testRestTemplate) throws Exception {

        Produce produce = new Produce(1L, "glass", 2000);

        Produce p_f = testRestTemplate
                .getForObject("/produce/reactive/get", Produce.class);
        Assertions.assertThat(p_f).isEqualTo(produce);

    }


}
