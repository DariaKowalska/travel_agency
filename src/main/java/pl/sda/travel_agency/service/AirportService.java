package pl.sda.travel_agency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sda.travel_agency.model.Airport;

import pl.sda.travel_agency.repository.AirportRepository;

import java.util.List;

@Service
public class AirportService {
    AirportRepository airportRepository;
@Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
    public List<Airport> getAllAirport() {return airportRepository.findAll();}

    public void addAirport(Long id_airport, String cityOfTheAirport){
    Airport airport = new Airport(id_airport, cityOfTheAirport);
    airportRepository.save(airport);
    }}





