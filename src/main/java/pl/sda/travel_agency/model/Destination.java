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
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_destination;
    private String airport;
    private String hotel;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY, mappedBy = "destination")

    private List<Trip>trips;

    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY, mappedBy = "destination")

    private List<Hotel>hotels;


    //TODO
    //konstruktor
    //toString
}
