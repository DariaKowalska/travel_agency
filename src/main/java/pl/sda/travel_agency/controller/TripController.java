package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.controller.dto.UserDto;
import pl.sda.travel_agency.model.*;
import pl.sda.travel_agency.service.TripService;
import pl.sda.travel_agency.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TripController {

    private TripService tripService;
    private UserService userService;

    @Autowired
    public TripController(TripService tripService, UserService userService) {
        this.tripService = tripService;
        this.userService = userService;
    }

    @GetMapping("/show")
    public String getAllTrip(Model model) {
        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);
        return "show";
    }

    @GetMapping(value = "/lastminute")
    public String getTripByPromotion(@RequestParam(required = false) String promotion, Model model) {
        model.addAttribute("promotedTrips", tripService.getTripByPromotion(promotion));
        return "promoted";
    }

    @GetMapping(value = "/continent")
    public String getTripByContinent(@RequestParam(required = false) String continent, Model model) {
        model.addAttribute("tripsList", tripService.getTripByContinent(continent));
        return "continent";
    }

    @GetMapping(value = "/country")
    public String getTripByCountry(@RequestParam(required = false) String country, Model model) {
        model.addAttribute("tripsList", tripService.getTripByCountry(country));
        return "country";
    }

    @GetMapping(value = "/find")
    public String getTripByPromotionAndDestinationContinentAndDestinationCountry(@RequestParam(required = false) String promotion,
                                                                                 @RequestParam(required = false) String continent,
                                                                                 @RequestParam(required = false) String country,
                                                                                 Model model) {
        model.addAttribute("tripsList", tripService.getByPromotionAndDestinationContinentAndDestinationCountry(promotion, continent, country));
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

    @GetMapping("/buyTrip")
    public String buyTrip(Model model, Authentication auth
    ) {
        model.addAttribute("auth", auth);
        model.addAttribute("trip", new TripDto());
        model.addAttribute("user", new UserDto());
        return "buyTripForm";
    }

    @PostMapping("/buyTrip")
    public String buyTrip(@ModelAttribute("trip") @Valid TripDto tripDto, @ModelAttribute("user") @Valid UserDto userDto,
                          BindingResult bindingResult) {

//        if (bindingResult.hasErrors()) {
//            return "/resultPage";
//        }

        tripService.buyTrip(tripDto, userDto);
        return "redirect:/";
    }


}
