package com.airline.reservations;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class appController {

    @GetMapping("/home")
    public String greetingForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservationsearch";
    }

    @PostMapping("/reservationsearch")
    public String greetingSubmit(@ModelAttribute Reservation reservation, Model model) {
        model.addAttribute("reservation", reservation);
        return "result";
    }

}

