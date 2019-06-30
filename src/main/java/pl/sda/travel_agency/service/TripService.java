package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.model.Departure;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.enums.FeedingEnum;
import pl.sda.travel_agency.repository.TripRepository;

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


    public List<Trip> getAllTrip() {
        return tripRepository.findAll();
    }



    public void saveTrip(TripDto tripDto) {

        Trip trip = new Trip( tripDto.getDepartureTime(),
                tripDto.getArrivalTime(), tripDto.getFeedingType(), tripDto.getPlaceForChildren(), tripDto.getPlaceForAdult(), tripDto.getPricePerAdult(), tripDto.getPricePerChild(), tripDto.getPromotionalPrice(), tripDto.getDeparture(), tripDto.getDestination());
        System.out.println("AAAAAAAAAAAA" + tripDto.getDeparture());
//
        tripRepository.save(trip);


    }

}

