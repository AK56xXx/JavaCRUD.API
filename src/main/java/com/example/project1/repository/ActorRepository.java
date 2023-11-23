package com.example.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor,Integer>  {
    
}
