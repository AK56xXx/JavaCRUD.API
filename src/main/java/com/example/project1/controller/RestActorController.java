package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.entities.Actor;
import com.example.project1.service.IServiceActor;

@RestController
@RequestMapping("/api/actors")
public class RestActorController {

    @Autowired
    private IServiceActor iServiceActor;

    @GetMapping("")
    public List<Actor> getAllAcotrs() {
        return iServiceActor.findAllActors();
    }

    @GetMapping("/{id}")
    public Actor findActorById(@PathVariable int id) {
        return iServiceActor.findActorById(id);
    }

    @PostMapping("/add")
    public Actor addActor(@RequestBody Actor actor) {
        return iServiceActor.createActor(actor);
    }

    @PutMapping("/update")
    public Actor updateActor(@RequestBody Actor actor) {
        return iServiceActor.updateActor(actor);
    }

    @DeleteMapping("/{id}")
    public void DeleteActor(@PathVariable int id) {
        iServiceActor.deleteActor(iServiceActor.findActorById(id));
    }

}
