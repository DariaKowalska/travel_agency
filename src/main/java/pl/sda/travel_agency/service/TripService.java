package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.model.Departure;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;
import pl.sda.travel_agency.model.enums.FeedingEnum;
import pl.sda.travel_agency.repository.TripRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TripService {
    TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;

    }

/*    public List<Trip> getAllTrip(Long id_trip) {
        return tripRepository.findAllById(id_trip);
    }*/

    public List<Trip> getTripByPromotion(Trip promotion) {
        return tripRepository.findAllByPromotion(promotion);
    }

    public List<Trip> getTripByContinent(ContinentEnum continentEnum) {
        return tripRepository.findAllByDestinationContinentEnum(continentEnum);
    }

    public List<Trip> getTripByCountry(CountryEnum countryEnum) {
        return tripRepository.findAllByDestinationCountryEnum(countryEnum);
    }



    public void saveTrip(TripDto tripDto) {

        Trip trip = new Trip(
                tripDto.getDepartureTime(),
                tripDto.getArrivalTime(),
                tripDto.getFeedingType(),
                tripDto.getPricePerAdult(),
                tripDto.getPricePerChild(),
                tripDto.getPromotionalPrice(),
                tripDto.getPlaceForAdult(),
                tripDto.getPlaceForChildren(),
                tripDto.getDeparture(),
        tripDto.getDestination());
        tripRepository.save(trip);
    }

}

