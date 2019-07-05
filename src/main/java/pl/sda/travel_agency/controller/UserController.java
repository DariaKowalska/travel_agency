package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.travel_agency.controller.dto.UserDto;
import pl.sda.travel_agency.model.Trip;
import pl.sda.travel_agency.service.TripService;
import pl.sda.travel_agency.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    UserService userService;
    TripService tripService;

    @Autowired
    public UserController(UserService userService, TripService tripService) {
        this.tripService = tripService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserDto());
        return "registerForm";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        userService.saveUser(userDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "loginForm";
    }

    @GetMapping("/")
    public String showIndex(Model model, Authentication auth) {
        model.addAttribute("auth", auth);

        Trip t1 = tripService.findTrip(5L);
        model.addAttribute("t1", t1);
        Trip t2 = tripService.findTrip(6L);
        model.addAttribute("t2", t2);
        Trip t3 = tripService.findTrip(7L);
        model.addAttribute("t3", t3);
        Trip t4 = tripService.findTrip(8L);
        model.addAttribute("t4", t4);
        Trip t5 = tripService.findTrip(9L);
        model.addAttribute("t5", t5);
        Trip t6 = tripService.findTrip(10L);
        model.addAttribute("t6", t6);

        return "index";
    }

}
