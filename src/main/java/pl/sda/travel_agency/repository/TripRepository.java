package pl.sda.travel_agency.repository;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.model.QDeparture;
import pl.sda.travel_agency.model.QTrip;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {

    //wyciągnięcie wycieczek wszystkich do wyświetlenia na stronie głównej
    List<Trip> findAllTrip();

    //wyciągnięcie wycieczek promowanych z repo do wyświetlenia na stronie głównej
    List<Trip> findAllByPromotion(Trip promotion);

    //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej

    List<Trip> findAllByDestinationContinentEnum(ContinentEnum continentEnum);


    //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej

    List<Trip> findAllByDestinationCountryEnum(CountryEnum countryEnum); }

