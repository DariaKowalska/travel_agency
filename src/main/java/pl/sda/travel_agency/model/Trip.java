package pl.sda.travel_agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.travel_agency.model.enums.FeedingEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_trip;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private FeedingEnum feedingType;
    private BigDecimal pricePerAdult;
    private BigDecimal pricePerChild;
    private BigDecimal promotionalPrice;
    private Integer placeForAdult;
    private Integer placeForChildren;
    private boolean promotion=false;


   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport")

    private Airport airport;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "id_destination")

    private Destination destination;

    public Trip(Integer placeForAdult, Integer placeForChildren, LocalDate departureTime, LocalDate arrivalTime, FeedingEnum feedingType, BigDecimal pricePerAdult, BigDecimal pricePerChild, BigDecimal promotionalPrice) {
        this.placeForAdult = placeForAdult;
        this.placeForChildren = placeForChildren;
        this.departureTime=departureTime;
        this.arrivalTime= arrivalTime;
        this.feedingType=feedingType;
    this.pricePerAdult=pricePerAdult;
    this.pricePerChild=pricePerChild;
    this.promotionalPrice=promotionalPrice;
    }

    public Trip(LocalDate departureTime, LocalDate arrivalTime, FeedingEnum feedingType, BigDecimal pricePerAdult, BigDecimal pricePerChild, BigDecimal promotionalPrice, Integer placeForAdult, Integer placeForChildren, Airport airport, Destination destination
    ) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.feedingType = feedingType;
        this.pricePerAdult = pricePerAdult;
        this.pricePerChild = pricePerChild;
        this.promotionalPrice = promotionalPrice;
        this.placeForAdult = placeForAdult;
        this.placeForChildren = placeForChildren;
        this.airport=airport;
        this.destination=destination;
    }
}
