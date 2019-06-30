package pl.sda.travel_agency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.travel_agency.controller.dto.UserDto;
import pl.sda.travel_agency.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
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
        return "index";
    }

}
