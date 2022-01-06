package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class BookingModel {


    public BookingModel(String id, String reserveName, LocalDate checkIn, LocalDate checkOut, String numberGuests) {
        this.id = id;
        this.reserveName = reserveName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberGuests = numberGuests;
    }

    private String id;
    private String reserveName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String numberGuests;


}
