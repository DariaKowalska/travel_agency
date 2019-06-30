package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.travel_agency.model.Departure;

import java.util.List;

public interface DepartureRepository extends JpaRepository<Departure, Long> {
    List<Departure> findAll();
}
