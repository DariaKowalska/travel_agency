package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.model.Departure;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.enums.FeedingEnum;
import pl.sda.travel_agency.model.enums.StandardEnum;
import pl.sda.travel_agency.service.TripService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class TripController {


    TripService tripService;

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




}
