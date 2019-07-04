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
import pl.sda.travel_agency.model.Departure;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.User;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;
import pl.sda.travel_agency.model.enums.FeedingEnum;
import pl.sda.travel_agency.model.enums.StandardEnum;
import pl.sda.travel_agency.repository.TripRepository;
import pl.sda.travel_agency.service.TripService;
import pl.sda.travel_agency.service.UserService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class TripController {

    TripService tripService;
    UserService userService;
    @Autowired
    public TripController(TripService tripService, UserService userService) {
        this.tripService = tripService; this.userService=userService;
    }




    @GetMapping("/trip")
    public String getAllTrip(Model model) {

        List<Trip> trips = tripService.getAllTrip();
        model.addAttribute("trips", trips);
        return "index";
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
    ){
model.addAttribute("auth", auth);
model.addAttribute("trip", new TripDto());
model.addAttribute("user", new UserDto());
        return "buyTripForm";
    }
    @PostMapping("/buyTrip")
    public String buyTrip( @ModelAttribute ("trip") @Valid TripDto tripDto, @ ModelAttribute ("user") @Valid UserDto userDto,
                           BindingResult bindingResult) {

//        if (bindingResult.hasErrors()) {
//            return "/resultPage";
//        }

  tripService.buyTrip(tripDto,userDto);
        return "redirect:/";
    }







}
