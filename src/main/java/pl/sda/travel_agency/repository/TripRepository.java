package pl.sda.travel_agency.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAll();

    //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej

    List<Trip> findAllByDestinationContinentEnum(ContinentEnum continentEnum);

    List<Trip> findAllByDestinationCountryEnum(CountryEnum countryEnum);

}
