package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.sda.travel_agency.model.*;

import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {

    //wyciągnięcie wycieczek wszystkich do wyświetlenia na stronie głównej
    List<Trip> findAllTrip();

 //wyciągnięcie wycieczek promowanych z repo do wyświetlenia na stronie głównej
  List<Trip> findByPromotion (Trip promotion);


   //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej
   @Query(value = "select t1 from trip t1 where exists (select t2 from destination t2 where exists (select t3 from hotel t3 where exists (select t4 from city t4 where exists (select t5 from country t5 where exists (select t6 from continent t6 where t6.name = ?1 )))))")
   List<Trip> findByContinent(Continent name_continent);

    //wyciągnięcie wycieczek ze względu na podział na kontynenty do wyświetlenia na stronie głównej
    @Query(value = "select t1 from trip t1 where exists (select t2 from destination t2 where exists (select t3 from hotel t3 where exists (select t4 from city t4 where exists (select t5 from country t5 where t5.name = :name and t5.id_continent =:continent))))")
    List<Trip> findByContinentAndCountry (@Param("name") Country name_country,
                                  @Param("continent") Continent id_continent);
}
