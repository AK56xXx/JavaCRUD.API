package com.example.project1.service;

import java.util.List;

import com.example.project1.entities.Actor;

public interface IServiceActor {

    public Actor createActor(Actor actor);

    public Actor findActorById(int id);

    public Actor updateActor(Actor actor);

    public List<Actor> findAllActors();

    public void deleteActor(Actor actor);

}
