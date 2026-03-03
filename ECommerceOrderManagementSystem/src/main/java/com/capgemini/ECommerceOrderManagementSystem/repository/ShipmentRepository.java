package com.capgemini.ECommerceOrderManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ECommerceOrderManagementSystem.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

}
