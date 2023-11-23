package com.example.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project1.entities.Actor;
import com.example.project1.service.IServiceActor;


@Controller
@RequestMapping("/actor")
public class ActorController {
    IServiceActor iServiceActor;
    
    public ActorController (IServiceActor iServiceActor){
        this.iServiceActor = iServiceActor;
    }

     @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("actors", iServiceActor.findAllActors());
        return "showActors"; //calling html template
    }

    @GetMapping("/new")
    public String affichenewform(Model model){
        // send the attribute and its related value with the url
        return "addActor";
    }

    @PostMapping("/add")
    public String add(Actor Actor){
        iServiceActor.createActor(Actor);
        return "redirect:/actor/all"; //redirect to the showCategories page using its url
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        // send the attribute and its related value with the url (to the edit form)
        model.addAttribute("actor", iServiceActor.findActorById(id));
        return "editActor";
    }

    @PostMapping("/update")
    public String update(Actor Actor){
        // submit update from the edit form
        iServiceActor.updateActor(Actor);
        return "redirect:/actor/all";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        iServiceActor.deleteActor(iServiceActor.findActorById(id));;
        return "redirect:/actor/all";
    }
    
}
