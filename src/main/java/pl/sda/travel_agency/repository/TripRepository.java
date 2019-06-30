package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.model.enums.CityEnum;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;

import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {


 /*   //wyciągnięcie wycieczek wszystkich do wyświetlenia na stronie głównej
    List<Trip> findAllById(Long id_trip);*/

    //wyciągnięcie wycieczek promowanych z repo do wyświetlenia na stronie głównej
    List<Trip> findAllByPromotion(Trip promotion);

    //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej

    List<Trip> findAllByDestinationContinentEnum(ContinentEnum continentEnum);


    //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej

    List<Trip> findAllByDestinationCountryEnum(CountryEnum countryEnum);

//wyszukiwanie wycieczek przez użytkownika
//
//    @Query("select t from Trip t where t.departureCityEnum =?1 and t.destinationContinentEnum = ?2")
//    List<Trip> findByDepartureCityEnumAndDestinationContinentEnum(CityEnum cityEnum, ContinentEnum continentEnum);
}
