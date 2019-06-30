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

    public void addTrip(Long tripId,
                        LocalDate departureTime,
                        LocalDate arrivalTime,
                        FeedingEnum feedingType,
                        BigDecimal pricePerAdult,
                        BigDecimal pricePerChild,
                        BigDecimal promotionalPrice,
                        Integer placeForAdult,
                        Integer placeForChildren,
                        String promotion,
                        Departure departure,
                        Destination destination

    ) {
        Trip trip = new Trip(tripId, departureTime, arrivalTime, feedingType, pricePerAdult, pricePerChild, promotionalPrice, placeForAdult, placeForChildren, promotion, departure, destination);
        tripRepository.save(trip);
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

