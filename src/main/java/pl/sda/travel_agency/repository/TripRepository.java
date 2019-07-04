package pl.sda.travel_agency.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.travel_agency.model.*;


import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAll();

    Trip findByTripId(Long tripId);

    List<Trip> findAllByPromotion(String promotion);

    List<Trip> findByDestinationContinent(String continent);

    List<Trip> findByDestinationCountry(String country);

    List<Trip> findByPromotionAndDestinationContinentAndDestinationCountry(String promotion, String continent, String country);

}

