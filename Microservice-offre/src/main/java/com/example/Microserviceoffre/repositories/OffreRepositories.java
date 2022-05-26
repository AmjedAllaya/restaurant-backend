package com.example.Microserviceoffre.repositories;

import com.example.Microserviceoffre.models.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreRepositories extends JpaRepository<Offre,Integer> {
}
