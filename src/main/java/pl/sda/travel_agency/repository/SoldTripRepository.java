package pl.sda.travel_agency.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.travel_agency.model.SoldTrip;
import pl.sda.travel_agency.model.Trip;

import java.util.List;

public interface SoldTripRepository extends JpaRepository<Trip,Long> {

   /* // wyciągnięcie z repo wycieczek po dacie zakupu, aby wyświetlić ostatnio zakupione wycieczki na stronie głównej
    List<SoldTrip> findAllBySoldDate(SoldDate soldDate, Sort sort);*/


}
