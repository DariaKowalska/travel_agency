package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.sda.travel_agency.controller.dto.TripDto;
import pl.sda.travel_agency.model.Departure;
import pl.sda.travel_agency.model.Destination;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.model.enums.ContinentEnum;
import pl.sda.travel_agency.model.enums.CountryEnum;
import pl.sda.travel_agency.model.enums.FeedingEnum;
import pl.sda.travel_agency.model.enums.StandardEnum;
import pl.sda.travel_agency.repository.TripRepository;
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

        tripService.saveTrip(tripDto);
        return "redirect:/";
    }


   /* @GetMapping("/trip")
    public String getAllTrip(Model model) {
        List<Trip> trips = tripService.getAllById(id_trip);
        model.addAttribute("trips", trips);
        return "index";
    }*/

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

//
//    @PostMapping("/addPost/{user_id}")
//    public void addPost(
//            String title,
//            String content,
//            CategoryEnum category,
//            @PathVariable Long user_id){
//        postService.addPost(title, content, category, user_id);
//    }

/*    @PostMapping("/addTrip/{Admin_id}")
    public void addTrip(

            @PathVariable Long admin_id){
        tripService.addTrip();
    }*/
}
