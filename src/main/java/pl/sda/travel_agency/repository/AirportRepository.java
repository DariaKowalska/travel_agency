package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.travel_agency.model.Airport;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findAll();
}
