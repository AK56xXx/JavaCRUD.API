package com.example.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.entities.Actor;
import com.example.project1.repository.ActorRepository;

//don't forget @Service 
@Service 
public class ServiceActor implements IServiceActor {


    @Autowired
    ActorRepository actorRepository;

    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor findActorById(int id) {
        return actorRepository.findById(id).get();
    }

    @Override
    public Actor updateActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public void deleteActor(Actor actor) {
       actorRepository.delete(actor);
    }
    
}
