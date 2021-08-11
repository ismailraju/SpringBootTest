package com.ismail.unittestone;

import com.ismail.unittestone.model.Produce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class MyWebTestClientReactiveTestOne {


//void addProduct(@Autowired WebTestClient webTestClient) throws  Exception {
//
//    Produce produce = new Produce("glass", 2000);
//    webTestClient
//        .post().uri("/produce/add")
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(BodyInserters.f)
//        .exchange()
//        .expectStatus().isOk()
//        .expectBody().json
//
//}

    @Test
    void getStaticProduct(@Autowired WebTestClient webTestClient) throws Exception {

        Produce produce = new Produce(1L, "glass", 2000);
        webTestClient
                .get().uri("/produce/reactive/get")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Produce.class).isEqualTo(produce);

    }


}
