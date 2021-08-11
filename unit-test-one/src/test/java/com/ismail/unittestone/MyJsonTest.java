package com.ismail.unittestone;


import com.ismail.unittestone.model.Produce;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
public class MyJsonTest {

    @Autowired
    private JacksonTester<Produce> produceJacksonTester;


    @Test
    void serialize() throws Exception {
        Produce produce = new Produce(1L,"glass", 2000);
//        Assertions.assertThat(produceJacksonTester.write(produce)).isEqualToJson("expected.json");

        Assertions.assertThat(produceJacksonTester.write(produce)).hasJsonPathStringValue("@.name");
        Assertions.assertThat(produceJacksonTester.write(produce)).extractingJsonPathStringValue("@.name").isEqualTo("glass");


    }


    @Test
    void deserialize() throws Exception {
        Produce produce = new Produce(1L,"glass", 2000);
        String content = "{\"id\":1,\"name\":\"glass\",\"price\":2000}";
        Assertions.assertThat(produceJacksonTester.parse(content)).isEqualTo(produce);
        Assertions.assertThat(produceJacksonTester.parseObject(content).getName()).isEqualTo("glass");
    }


}
