package pl.sda.travel_agency.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.travel_agency.model.Airport;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.enums.FeedingEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TripDto {

    private Long id_trip;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private FeedingEnum feedingType;
    private BigDecimal pricePerAdult;
    private BigDecimal pricePerChild;
    public static BigDecimal promotionalPrice;
    private Integer placeForAdult;
    private Integer placeForChildren;
    public static Boolean promotion;
    private Airport airport;
    private Destination destination;

//    public String getProductTypePl() {
//        return Optional.ofNullable(productType).map(e -> e.getType()).orElse("");
//    }
}
