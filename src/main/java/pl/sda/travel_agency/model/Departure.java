package pl.sda.travel_agency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.travel_agency.model.enums.CityEnum;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departureId;
    private CityEnum cityEnum;



//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            fetch = FetchType.LAZY, mappedBy = "departure")

   // private List<Trip> trips;



}
