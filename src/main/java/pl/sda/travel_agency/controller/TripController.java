package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.controller.dto.UserDto;
import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.repository.TripRepository;
import pl.sda.travel_agency.service.TripService;
import pl.sda.travel_agency.service.UserService;

import javax.validation.Valid;
import java.util.List;
@Controller
public class TripController {

    private TripService tripService;
    private UserService userService;
    private TripRepository tripRepository;

    @Autowired
    public TripController(TripService tripService, UserService userService, TripRepository tripRepository) {
        this.tripService = tripService;
        this.userService = userService;
        this.tripRepository = tripRepository;
    }

    @GetMapping("/show")
    public String getAllTrip(Model model) {
        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);
        return "show";
    }

    @GetMapping(value = "/find")
    public String getTripByDestinationContinentAndDestinationCountry(@RequestParam(required = false) String continent,
                                                                     @RequestParam(required = false) String country,
                                                                     Model model) {
        model.addAttribute("tripsList", tripService.getByDestinationContinentAndDestinationCountry(continent, country));
        return "findPage";
    }

    @GetMapping("/admin/addTripForm")
    public String getTrip(Model model) {
        model.addAttribute("trip", new TripDto());
        return "/admin/addTripForm";
    }

    @PostMapping("/admin/addTripForm")
    public String register(@ModelAttribute("trip") @Valid TripDto tripDto,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/resultPage";
        }

        tripService.addTrip(tripDto);
        return "redirect:/";
    }

    @GetMapping("/buyTrip/{tripId}")
    public String buyTrip(@PathVariable("tripId") Long tripId, Model model, Authentication auth) {
        model.addAttribute("auth", auth);
        model.addAttribute("user", new UserDto());
        model.addAttribute("trip",tripService.findTrip(tripId) );
        return "buyTripForm";
    }

    @PostMapping("/buyTrip/{tripId}")
    public String buyTrip(@PathVariable("tripId") Long tripId, Authentication auth) {
        String email = ((UserDetails)auth.getPrincipal()).getUsername();
        tripService.buyTrip(email,tripId);
        return "redirect:/";
    }
    @GetMapping("/summary")
    public String summary(){
        return "summary";
    }

    @GetMapping("/kontynent/{continent}")
    public String getTripByContinent(@PathVariable String continent, Model model) {
        model.addAttribute("trips", tripService.findTripByContinent(continent));
        return "continentPage";
    }


    @GetMapping("panstwo/{country}")
    public String getTripByCountry(@PathVariable String country, Model model) {
        model.addAttribute("trips", tripService.findTripByCountry(country));
        return "continentPage";
    }

}
