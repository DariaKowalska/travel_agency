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
    private Long tripId;
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
    @JoinColumn(name = "departureId")
    private Departure departure;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "destinationId")
    private Destination destination;



    public Trip(LocalDate departureTime, LocalDate arrivalTime, FeedingEnum feedingType, BigDecimal pricePerAdult, BigDecimal pricePerChild, BigDecimal promotionalPrice, Integer placeForAdult, Integer placeForChildren, Departure departure, Destination destination) {


    }

    public Trip(LocalDate departureTime, LocalDate arrivalTime, FeedingEnum feedingType, BigDecimal pricePerAdult, BigDecimal pricePerChild, BigDecimal promotionalPrice, Integer placeForAdult, Integer placeForChildren, boolean promotion, Departure departure, Destination destination) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.feedingType = feedingType;
        this.pricePerAdult = pricePerAdult;
        this.pricePerChild = pricePerChild;
        this.promotionalPrice = promotionalPrice;
        this.placeForAdult = placeForAdult;
        this.placeForChildren = placeForChildren;
        this.promotion = promotion;
        this.departure = departure;
        this.destination = destination;
    }

    //    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            fetch = FetchType.LAZY, mappedBy = "trip")


}
