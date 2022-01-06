package com.estudostdd.TestesMock;

import com.estudostdd.repository.BookingRepository;
import com.estudostdd.service.BookingServices;
import model.BookingModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration {
        @Bean
        public BookingServices bookingServices () {
            return new BookingServices();
        }
    }

    @Autowired
    BookingServices bookingServices;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingServiceDaysCalculatorTest() {
        String name = "Clara Martins";
        int days = bookingServices.daysCalculatorWithDatabase(name);

        Assertions.assertEquals(days, 10);
    }

    @Before
    public void setup() {
        LocalDate checkIn = LocalDate.parse("2021-12-20");
        LocalDate checkOut = LocalDate.parse("2021-12-30");
        BookingModel bookingModel = new BookingModel("1", "Clara Martins", checkIn, checkOut, "5");

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(java.util.Optional.of(bookingModel));
    }
}
