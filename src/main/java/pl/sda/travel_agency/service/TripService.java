package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.controller.dto.UserDto;
import pl.sda.travel_agency.model.Departure;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.User;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;
import pl.sda.travel_agency.model.enums.FeedingEnum;
import pl.sda.travel_agency.repository.TripRepository;
import pl.sda.travel_agency.repository.UserRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TripService {
    TripRepository tripRepository;
    UserRepository userRepository;

    @Autowired
    public TripService(TripRepository tripRepository, UserRepository userRepository) {
        this.tripRepository = tripRepository;
        this.userRepository=userRepository;

    }

public List<Trip> getAllTrip() {
       return tripRepository.findAll();
   }
//
   public void buyTrip(TripDto tripDto, UserDto userDto){
       User user = userRepository.findFirstByEmail(userDto.getEmail());
       Trip trip = tripRepository.findByTripId(tripDto.getTripId());
       trip.getUsers().add(user);
       user.getTrips().add(trip);
       userRepository.save(user);
       tripRepository.save(trip);

   }

//    public List<Trip> getTripByPromotion(Trip promotion) {
//        return tripRepository.findAllByPromotion(promotion);
//    }


    public User findUser(String email){
        return userRepository.findFirstByEmail(email);
    }



    public void addTrip(TripDto tripDto) {

        Trip trip = new Trip(tripDto.getDepartureTime(),
                tripDto.getArrivalTime(), tripDto.getFeedingType(), tripDto.getPlaceForChildren(), tripDto.getPlaceForAdult(), tripDto.getPricePerAdult(), tripDto.getPricePerChild(), tripDto.getPromotionalPrice(), tripDto.getDeparture(), tripDto.getDestination());



        tripRepository.save(trip);
    }

    public Trip findTrip(Long tripId) {
        return tripRepository.findFirstByTripId(tripId);
    }

    public List<Trip> findTripByContinent(String continent) {
        return tripRepository.findAllByContinent(continent);
    }

    public List<Trip>findTripByCountry(String country){
        return tripRepository.findAllByCountry(country);
    }

}

