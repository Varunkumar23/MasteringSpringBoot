package com.capgemini.ECommerceOrderManagementSystem.service;

import java.util.List;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.ShipmentRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.ShipmentResponse;
import com.capgemini.ECommerceOrderManagementSystem.entity.Shipment;

public interface ShipmentService {

	ShipmentResponse createShipment(ShipmentRequest shipmentRequest);

	ShipmentResponse getShipmentById(int id);

	List<ShipmentResponse> getAllShipments();

	ShipmentResponse updateShipment(int id, ShipmentRequest shipmentRequest);

	String deleteShipment(int id);

}
