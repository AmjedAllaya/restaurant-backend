package com.example.demo.ressources;


import com.example.demo.models.Event;
import com.example.demo.repositories.EventRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/events")
public class EventRessources {
    @Autowired
    EventRepositories eventRepositories;

    @GetMapping
// Affiche Liste des ordres
    public List<Event> allOrders() {
        List<Event> allOrders= eventRepositories.findAll();
        return allOrders;
    }
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter order:
    public Event addOrder(Event order) {
        return eventRepositories.save(order);
    }

    @PutMapping(value = "/{id}")
    // Update order
    public Event updateOrder(int id, Event newOrder) {
        if (eventRepositories.findById(id).isPresent()) {
            Event existingOrder = eventRepositories.findById(id).get();
            existingOrder.setDescription(newOrder.getDescription());
            existingOrder.setName(newOrder.getName());
            return eventRepositories.save(existingOrder);
        } else
            return null;
    }

    @DeleteMapping(value = "/{id}")
    // Delete Order
    public String deleteOrder(int id) {
        if (eventRepositories.findById(id).isPresent()) {
            eventRepositories.deleteById(id);
            return "event supprimé";
        } else {
            return "event non supprimé";
        }
    }

}
