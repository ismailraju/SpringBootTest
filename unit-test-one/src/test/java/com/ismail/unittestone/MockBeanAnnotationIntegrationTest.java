package com.ismail.unittestone;


import com.ismail.unittestone.repository.ProduceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MockBeanAnnotationIntegrationTest {

    @MockBean
    ProduceRepository produceRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
        Mockito.when(produceRepository.count()).thenReturn(123L);

        ProduceRepository userRepoFromContext = applicationContext.getBean(ProduceRepository.class);
        long userCount = userRepoFromContext.count();

        Assertions.assertThat(123L).isEqualTo(userCount);
        Mockito.verify(produceRepository).count();
    }

}
