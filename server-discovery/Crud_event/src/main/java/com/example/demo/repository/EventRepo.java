package com.example.demo.repository;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event, Long> {
}
