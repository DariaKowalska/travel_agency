package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
//    @GetMapping("/register")
//    public String register(Model model){
//        model.addAttribute("user", new UserDto());
//        return "registerForm";

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

    //    @PostMapping("/register")
//    public String register(@ModelAttribute("user") @Valid UserDto userDto,
//                           BindingResult bindingResult){
//
//        if(bindingResult.hasErrors()){
//            return "registerForm";
//        }
//
//        userService.saveUser(userDto);
//        return "redirect:/";
//    }
    @PostMapping("/addTrip/")
    public void addTrip(Long id_trip,
                        LocalDate departureTime,
                        LocalDate arrivalTime,
                        FeedingEnum feedingType,
                        BigDecimal pricePerAdult,
                        BigDecimal pricePerChild,
                        BigDecimal promotionalPrice,
                        Integer placeForAdult,
                        Integer placeForChildren,
                        boolean promotion,
                        Departure departure,
                        Destination destination
    ) {
        tripService.addTrip(id_trip, departureTime, arrivalTime, feedingType, pricePerAdult, pricePerChild, promotionalPrice, placeForAdult, placeForChildren, promotion, departure, destination);
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
