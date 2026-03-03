package com.capgemini.ECommerceOrderManagementSystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "trackingevents")
public class TrackingEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String eventType;
	
	@Column(nullable = false)
	private LocalDateTime timestamp;
	
	@Column(nullable = false)
	private String location;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipment_id", nullable = false)
	private Shipment shipment;

}
