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

    public List<Trip> getTripByPromotion(String promotion) {
        return tripRepository.findAllByPromotion(promotion);
    }

    public List<Trip> getTripByContinent(String continent) {
        return tripRepository.findByDestinationContinent(continent);
    }

    public List<Trip> getTripByCountry(String country) {
        return tripRepository.findByDestinationCountry(country);
    }

    public List<Trip> getByPromotionAndDestinationContinentAndDestinationCountry(String promotion, String continent, String country) {
        return tripRepository.findByPromotionAndDestinationContinentAndDestinationCountry(promotion, continent, country);
    }

    public void buyTrip(TripDto tripDto, UserDto userDto) {
        User user = userRepository.findFirstByEmail(userDto.getEmail());
        Trip trip = tripRepository.findByTripId(tripDto.getTripId());
        trip.getUsers().add(user);
        user.getTrips().add(trip);
        userRepository.save(user);
        tripRepository.save(trip);

    }

    public User findUser(String email) {
        return userRepository.findFirstByEmail(email);
    }

    public Trip findTrip(Long tripId) {
        return tripRepository.findByTripId(tripId);
    }


    public void addTrip(TripDto tripDto) {

        Trip trip = new Trip(tripDto.getDepartureTime(), tripDto.getArrivalTime(), tripDto.getFeedingType(),
                tripDto.getPlaceForChildren(), tripDto.getPlaceForAdult(), tripDto.getPricePerAdult(),
                tripDto.getPricePerChild(), tripDto.getPromotionalPrice(), tripDto.getPromotion(),
                tripDto.getDeparture(), tripDto.getDestination());

        tripRepository.save(trip);
    }

}

