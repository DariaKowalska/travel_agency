package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.travel_agency.model.Trip;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    //wyciągnięcie wycieczek wszystkich do wyświetlenia na stronie głównej
    List<Trip> findAll();



 /*   //wyciągnięcie wycieczek promowanych z repo do wyświetlenia na stronie głównej
    List<Trip> findAllByPromotion (Promotion promotion);


   //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej
    List<Trip> findAllByContinent (Continent continent);

    //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej
    List<Trip> findAllByCountry (Country country);*/

}
