package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.repository.TripRepository;

import java.util.List;
@Service
public class TripService {
TripRepository tripRepository;

@Autowired
    public TripService(TripRepository tripRepository){
    this.tripRepository = tripRepository;
}
/*
public List<Trip> getAllByPromotion(Promotion promotion){
    return tripRepository.findAllByPromotion(promotion);
}*/

public List<Trip> getAllTrip(){
    return tripRepository.findAll();
}
/*
public List<Trip> getAllByContinent(Continent continent){
    return tripRepository.findAllByContinent(continent);
}

public List<Trip> getAllByCountry(Country country){
    return tripRepository.findAllByCountry(country);
}*/
}
