package pl.sda.travel_agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.travel_agency.model.enums.FeedingEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    private Boolean promotion;


   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_airport")

    private Airport airport;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "id_destination")

    private Destination destination;


    //TODO
    //konstruktor
    //toString
}
