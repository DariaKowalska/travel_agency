package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;



import org.springframework.web.bind.annotation.*;


import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.service.TripService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TripController {

    TripService tripService;
    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @RequestMapping("/findPage")
    public String getAllTrip(Model model) {
        model.addAttribute("trips", tripService.getAllTrip());
        return "findPage";
    }
    @GetMapping("/kontynent/{continentEnum}")
    public String getTripByContinent(Model model, @PathVariable("continentEnum") String continentEnum) {
        List<Trip> trips = tripService.getTripByContinent(continentEnum);
        model.addAttribute("trips", trips);
        return "continentPage";
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
