package pl.sda.travel_agency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.travel_agency.model.Destination;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findAll();
    Destination findDestinationByDestinationId(Long destinationId);
}
