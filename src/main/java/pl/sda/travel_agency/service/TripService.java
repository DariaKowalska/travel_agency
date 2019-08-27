package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.controller.dto.UserDto;
import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.repository.TripRepository;
import pl.sda.travel_agency.repository.UserRepository;

import java.util.List;

@Service
public class TripService {
    private TripRepository tripRepository;
    private UserRepository userRepository;

    @Autowired
    public TripService(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;

    }

    public List<Trip> getAllTrip() {
        return tripRepository.findAll();
    }

    public List<Trip> getByDestinationContinentAndDestinationCountry(String continent, String country) {
        return tripRepository.findByDestinationContinentAndDestinationCountry(continent, country);
    }

    public User findUser(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public void addTrip(TripDto tripDto) {

        Trip trip = new Trip(tripDto.getDepartureTime(),
                tripDto.getArrivalTime(), tripDto.getFeedingType(), tripDto.getPlaceForChildren(),
                tripDto.getPlaceForAdult(), tripDto.getPricePerAdult(), tripDto.getPricePerChild(),
                tripDto.getPromotionalPrice(), tripDto.getDeparture(), tripDto.getDestination());
        tripRepository.save(trip);
    }

    public Trip findTrip(Long tripId) {
        return tripRepository.findFirstByTripId(tripId);
    }

    public List<Trip> findTripByContinent(String continent) {
        return tripRepository.findByDestinationContinent(continent);
    }

    public List<Trip> findTripByCountry(String country) {
        return tripRepository.findByDestinationCountry(country);
    }


    public void buyTrip(String email, Long tripId) {
        User user = userRepository.findFirstByEmail(email);
        Trip trip = tripRepository.findByTripId(tripId);

        trip.getUsers().add(user);
        tripRepository.save(trip);

    }
}

