package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    TripRepository tripRepository;

    @Autowired
    public TripController(TripService tripService, UserService userService,TripRepository tripRepository) {
        this.tripService = tripService;
        this.userService=userService;
        this.tripRepository = tripRepository;
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





    @GetMapping("/kontynent/europa")
    public String getTripByContinentEuropa(Model model) {
        model.addAttribute("trips", tripService.findTripByContinent("EUROPA"));
        return "continentPage";
    }

    @GetMapping("/kontynent/azja")
    public String getTripByContinentAzja(Model model) {
        model.addAttribute("trips", tripService.findTripByContinent("AZJA"));
        return "continentPage";
    }

    @GetMapping("/kontynent/afryka")
    public String getTripByContinentAfryka(Model model) {
        model.addAttribute("trips", tripService.findTripByContinent("AFRYKA"));
        return "continentPage";
    }

    @GetMapping("/kontynent/ameryka")
    public String getTripByContinentAmeryka(Model model) {
        model.addAttribute("trips", tripService.findTripByContinent("AMERYKA"));
        return "continentPage";
    }

    @GetMapping("panstwo/islandia")
    public String getTripByCountryIsland(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("ISLANDIA"));
        return "countryPage";
    }
    @GetMapping("panstwo/wlochy")
    public String getTripByCountryItaly(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("WŁOCHY"));
        return "countryPage";
    }
    @GetMapping("panstwo/hiszpania")
    public String getTripByCountrySpain(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("HISZPANIA"));
        return "countryPage";
    }
    @GetMapping("panstwo/chorwacja")
    public String getTripByCountryCroatia(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("CHORWACJA"));
        return "countryPage";
    }
    @GetMapping("panstwo/grecja")
    public String getTripByCountryGreece(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("GRECJA"));
        return "countryPage";
    }
    @GetMapping("panstwo/tajlandia")
    public String getTripByCountryThailand(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("TAJLANDIA"));
        return "countryPage";
    }
    @GetMapping("panstwo/japonia")
    public String getTripByCountryJapan(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("JAPONIA"));
        return "countryPage";
    }
    @GetMapping("panstwo/wietnam")
    public String getTripByCountryVietnam(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("WIETNAM"));
        return "countryPage";
    }
    @GetMapping("panstwo/nepal")
    public String getTripByCountryNepal(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("NEPAL"));
        return "countryPage";
    }
    @GetMapping("panstwo/maroko")
    public String getTripByCountryMarocco(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("MAROKO"));
        return "countryPage";
    }
    @GetMapping("panstwo/kenia")
    public String getTripByCountryKenya(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("KENIA"));
        return "countryPage";
    }
    @GetMapping("panstwo/namibia")
    public String getTripByCountryNamibia(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("NAMIBIA"));
        return "countryPage";
    }
    @GetMapping("panstwo/zanzibar")
    public String getTripByCountryZanzibar(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("ZANZIBAR"));
        return "countryPage";
    }
    @GetMapping("panstwo/usa")
    public String getTripByCountryUnitedStates(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("USA"));
        return "countryPage";
    }
    @GetMapping("panstwo/kanada")
    public String getTripByCountryCanada(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("KANADA"));
        return "countryPage";
    }
    @GetMapping("panstwo/brazylia")
    public String getTripByCountryBrasil(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("BRAZYLIA"));
        return "countryPage";
    }
    @GetMapping("panstwo/meksyk")
    public String getTripByCountryMexico(Model model){
        model.addAttribute("trips",tripService.findTripByCountry("MEKSYK"));
        return "countryPage";
    }
}
