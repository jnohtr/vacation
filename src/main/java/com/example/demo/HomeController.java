package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    PlaceRepository placeRepository;

    @RequestMapping("/")
    public String listFoods(Model model) {
        model.addAttribute("places", placeRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String foodForm(Model model) {
        model.addAttribute("place", new Place());
        return "placeform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Place place, BindingResult result) {
        if (result.hasErrors()) {
            return "placeform";
        }
        placeRepository.save(place);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showFood(@PathVariable("id") long id, Model model) {
        model.addAttribute("place", placeRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateFood(@PathVariable("id") long id, Model model) {
        model.addAttribute("place", placeRepository.findById(id));
        return "placeform";
    }

    @RequestMapping("/delete/{id}")
    public String delFood(@PathVariable("id") long id) {
        placeRepository.deleteById(id);
        return "redirect:/";
    }

}
