package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;
import pl.sda.travel_agency.service.TripService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class TripController {

    // pole do wstrzykniecia
    private TripService tripService;

    // wstrzyknięcie zależności przez konstruktor
    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/trip")
    public String getAllTrip(Model model) {
        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);
        return "index";
    }

    @PostMapping("/trip/{promotion}")
    public String getTripByPromotion(@PathVariable("promotion") Trip promotion) {
        return "promotionPage";
    }

    @PostMapping("/kontynent/{enumContinent}")
    public String getTripByContinent(@PathVariable("enumContinent") ContinentEnum continentEnum) {
        return "continentPage";
    }

    @PostMapping("/panstwo/{enumCountry}")
    public String getTripByCountry(@PathVariable("enumCountry") CountryEnum countryEnum) {
        return "countryPage";
    }
}

