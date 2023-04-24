package com.aurosoft.event.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="event_registration")
public class EventRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable= false)
	private int id;
	
	@Column(name="name", nullable= false)
	private String name;
	
	@Column(name="email", nullable= false)
	private String email;
	
	@Column(name="phone", nullable= false)
	private String phone;
	
	@Column(name="gender", nullable= false)
	private String gender;
	
	@Column(name="city", nullable= false)
	private String city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="event_id", referencedColumnName = "id", nullable = false)
	private Event event;
	
	

}
