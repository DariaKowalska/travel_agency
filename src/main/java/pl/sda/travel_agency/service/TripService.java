package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;
import pl.sda.travel_agency.repository.TripRepository;

import java.util.List;

@Service
public class TripService {
    TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;

    }

    public List<Trip> getAllTrip() {
        return tripRepository.findAll();
    }

    public List<Trip> getTripByContinent(String continentEnum) {
        return tripRepository.findAllByDestinationContinentEnum(continentEnum);
    }

    public List<Trip> getTripByCountry(String  countryEnum) {
        return tripRepository.findAllByDestinationCountryEnum(countryEnum);
    }

    public void addTrip(TripDto tripDto) {

        Trip trip = new Trip(tripDto.getDepartureTime(),
                tripDto.getArrivalTime(), tripDto.getFeedingType(), tripDto.getPlaceForChildren(), tripDto.getPlaceForAdult(), tripDto.getPricePerAdult(), tripDto.getPricePerChild(), tripDto.getPromotionalPrice(), tripDto.getDeparture(), tripDto.getDestination());

        tripRepository.save(trip);
    }

}

