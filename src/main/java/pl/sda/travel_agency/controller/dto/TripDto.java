package pl.sda.travel_agency.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.travel_agency.model.Departure;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.enums.FeedingEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TripDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalTime;
    private FeedingEnum feedingType;
    private Integer placeForAdult;
    private Integer placeForChildren;
    private BigDecimal pricePerAdult;
    private BigDecimal pricePerChild;
    BigDecimal promotionalPrice;
    private Departure departure;
     private Destination destination;


}
