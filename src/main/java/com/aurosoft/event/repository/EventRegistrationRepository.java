package com.aurosoft.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.event.entity.EventRegistration;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Integer> {

}
