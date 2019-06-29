package pl.sda.travel_agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_airport;
    private String cityOfTheAirport;


/*
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY, mappedBy = "airport")

    private List<Trip> trips;
*/

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city")

    private City city;

    public Airport(Long id_airport,String cityOfTheAirport) {
        this.id_airport=id_airport;
        this.cityOfTheAirport = cityOfTheAirport;
    }

//TODO
    //konstruktor
    //toString
}
