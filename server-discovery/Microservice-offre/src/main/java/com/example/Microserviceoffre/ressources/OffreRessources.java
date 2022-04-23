package com.example.Microserviceoffre.ressources;

import com.example.Microserviceoffre.models.Offre;
import com.example.Microserviceoffre.repositories.OffreRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/offers")
public class OffreRessources {
    @Autowired
    OffreRepositories offreRepositories;

    @GetMapping
// Affiche Liste des offres
    public List<Offre> allOffers() {
        List<Offre> allOffres =  offreRepositories.findAll();
        return allOffres;
    }
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter offers:
    public Offre addOffers(Offre offre) {
        return offreRepositories.save(offre);
    }

    @PutMapping(value = "/{id}")
    // Update offer
    public Offre updateOffer(int id, Offre newOffer) {
        if (offreRepositories.findById(id).isPresent()) {
            Offre existingOffer = offreRepositories.findById(id).get();
            existingOffer.setNom(newOffer.getNom());
            existingOffer.setRemise(newOffer.getRemise());
            return offreRepositories.save(existingOffer);

        } else
            return null;
    }

    @DeleteMapping(value = "/{id}")
    // Delete Offers
    public String deleteOffer(int id) {
        if (offreRepositories.findById(id).isPresent()) {
            offreRepositories.deleteById(id);
            return "Offre supprimé";
        } else {
            return "Offre non supprimé";
        }
    }

}
