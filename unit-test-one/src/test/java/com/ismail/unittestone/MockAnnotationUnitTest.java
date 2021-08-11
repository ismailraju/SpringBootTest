package com.ismail.unittestone;


import com.ismail.unittestone.repository.ProduceRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class MockAnnotationUnitTest {

    @Mock
    ProduceRepository produceRepository;

    @Test
    public void givenCountMethodMocked_WhenCountInvoked_ThenMockValueReturned() {
        Mockito.when(produceRepository.count()).thenReturn(123L);

        long produceCount = produceRepository.count();

        Assert.assertEquals(123L, produceCount);
        Mockito.verify(produceRepository).count();
    }

}
