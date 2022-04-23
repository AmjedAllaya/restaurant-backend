package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServices {

    @Autowired
    private EventRepo repo;

    public List<Event> listAll(){
        return repo.findAll();
    }

    public void save (Event event) {
        repo.save(event);
    }

    public Event get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
