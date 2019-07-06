package pl.sda.travel_agency.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.FeedingEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TripDto {
private Long tripId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalTime;
    private FeedingEnum feedingType;
    private Integer placeForAdult;
    private Integer placeForChildren;
    private BigDecimal pricePerAdult;
    private BigDecimal pricePerChild;
    private BigDecimal promotionalPrice;
    private String promotion;
    private String departure;
    private Destination destination;

     private ContinentEnum continentEnum;


}
