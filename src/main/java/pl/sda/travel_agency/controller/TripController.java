package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.service.TripService;

import java.util.List;

public class TripController {

        // pole do wstrzykniecia
        TripService tripService;

        // wstrzyknięcie zależności przez konstruktor
        @Autowired
        public TripController(TripService tripService) {
            this.tripService = tripService;
        }


    @GetMapping("/")
    public String getAllTrip(Model model) {

        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);

        return "index";
    }

/*    @PostMapping("/addTrip/{Admin_id}")
    public void addTrip(

            @PathVariable Long admin_id){
        tripService.addTrip();
    }*/
}
