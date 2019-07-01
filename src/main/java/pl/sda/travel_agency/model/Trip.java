package pl.sda.travel_agency.model;

import lombok.*;
import pl.sda.travel_agency.model.enums.FeedingEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "soldTrip", joinColumns = @JoinColumn(name = "tripId"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private Set<User> users;


    public Trip( LocalDate departureTime, LocalDate arrivalTime, FeedingEnum feedingType, Integer placeForChildren, Integer placeForAdult
    , BigDecimal pricePerAdult, BigDecimal pricePerChild, BigDecimal promotionalPrice,  Departure departure, Destination destination ){
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.feedingType=feedingType;
        this.placeForChildren=placeForChildren;
        this.placeForAdult=placeForAdult;
        this.pricePerAdult=pricePerAdult;
        this.pricePerChild=pricePerChild;
        this.promotionalPrice=promotionalPrice;
        this.departure=departure;
        this.destination=destination;
    }
            //,Integer placeForChildren, LocalDate arrivalTime, FeedingEnum feedingType, BigDecimal pricePerAdult, BigDecimal pricePerChild, BigDecimal promotionalPrice, Integer placeForAdult, Departure departure, Destination destination) {


    }

