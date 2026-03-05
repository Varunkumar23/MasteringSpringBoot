package com.capgemini.ECommerceOrderManagementSystem.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "shipments")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String trackingNumber;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false)
	private String customerEmail;

	@JoinColumn(name = "warehouse_id", nullable = false)
	@ManyToOne
	private Warehouse warehouse;

	@OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
	private List<TrackingEvent> trackingEvents;

}
