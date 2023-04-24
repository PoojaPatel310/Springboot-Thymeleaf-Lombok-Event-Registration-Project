package com.aurosoft.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.event.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
