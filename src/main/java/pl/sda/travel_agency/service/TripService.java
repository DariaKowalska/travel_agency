package pl.sda.travel_agency.service;

import com.querydsl.jpa.impl.JPAQuery;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;
import pl.sda.travel_agency.repository.TripRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class TripService {

    private TripRepository tripRepository;
    private EntityManager entityManager;

    @Autowired
    public TripService(TripRepository tripRepository, EntityManager entityManager) {
        this.tripRepository = tripRepository;
        this.entityManager = entityManager;
    }

    public List<Trip> getAllTrip() {
        return tripRepository.findAllTrip();
    }

    public List<Trip> getTripByPromotion(Trip promotion) {
        return tripRepository.findAllByPromotion(promotion);
    }

    public List<Trip> getTripByContinent(ContinentEnum continentEnum) {
        return tripRepository.findAllByDestinationContinentEnum(continentEnum);
    }

    public List<Trip> getTripByCountry(CountryEnum countryEnum) {
        return tripRepository.findAllByDestinationCountryEnum(countryEnum);
    }

}




