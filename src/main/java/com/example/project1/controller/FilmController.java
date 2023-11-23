package com.example.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project1.entities.Film;
import com.example.project1.service.IServiceActor;
import com.example.project1.service.IServiceCategory;
import com.example.project1.service.IServiceFilm;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    IServiceFilm iServiceFilm;

    @Autowired
    IServiceCategory iServiceCategory;

    @Autowired
    IServiceActor iServiceActor;


    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("films", iServiceFilm.findAllFilms());
        return "showFilms";
    }

    @GetMapping("/new")
    public String affichenewform(Model model){
        // send the attribute and its related value with the url
        model.addAttribute("categories", iServiceCategory.findAllCategories());
        model.addAttribute("actors", iServiceActor.findAllActors());
        return "addFilm";
    }

    @PostMapping("/add")
    public String add(Film f){
        iServiceFilm.createFilm(f);
        return "redirect:/film/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        // send the attribute and its related value with the url (to the edit form)
        model.addAttribute("film", iServiceFilm.findFilmById(id));
        model.addAttribute("categories", iServiceCategory.findAllCategories());
        model.addAttribute("actors", iServiceActor.findAllActors());
        return "editFilm";
    }

    @PostMapping("/update")
    public String update(Film f){
        // submit update from the edit form
        iServiceFilm.updateFilm(f);
        return "redirect:/film/all";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        iServiceFilm.deleteFilm(iServiceFilm.findFilmById(id));;
        return "redirect:/film/all";
    }

    // (*) notice : when you work with templates (not api) you only use post/get mapping (there is no PutMapping/DeleteMapping)
}
