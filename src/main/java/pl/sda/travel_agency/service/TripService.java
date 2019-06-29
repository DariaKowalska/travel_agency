package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.repository.TripRepository;

import java.util.List;
import java.util.Optional;


@Service
public class TripService {
TripRepository tripRepository;

@Autowired
    public TripService(TripRepository tripRepository){
    this.tripRepository = tripRepository;
}

public List<Trip> getAllTrip(){
    return tripRepository.findAllTrip();

public List<Trip> getTripByContinent(Continent name_continent){
    return tripRepository.findByContinent(name_continent);
}

public Optional<Trip> getAllByCountryandCountry(Country country){
    return tripRepository.findByContinentAndCountry(country);
}
}}



