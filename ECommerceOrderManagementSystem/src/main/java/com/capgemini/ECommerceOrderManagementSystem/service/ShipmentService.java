package com.capgemini.ECommerceOrderManagementSystem.service;

import java.util.List;

import com.capgemini.ECommerceOrderManagementSystem.entity.Shipment;

public interface ShipmentService {

	Shipment createShipment(Shipment shipment);

	Shipment getShipmentById(int id);

	List<Shipment> getAllSgipments();

	Shipment updateShipment(int id, Shipment shipment);

	void deleteShipment(int id);

}
