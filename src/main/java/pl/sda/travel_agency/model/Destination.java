package pl.sda.travel_agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.travel_agency.model.enums.CityEnum;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long destinationId;
    private CityEnum cityEnum;
    private CountryEnum countryEnum;
    private ContinentEnum continentEnum;
    private String hotel;

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            fetch = FetchType.LAZY, mappedBy = "destination")
//
//    private List<Trip> trips;
}
