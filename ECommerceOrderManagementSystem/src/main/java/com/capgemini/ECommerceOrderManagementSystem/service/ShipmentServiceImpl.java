package com.capgemini.ECommerceOrderManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.ECommerceOrderManagementSystem.entity.Shipment;
import com.capgemini.ECommerceOrderManagementSystem.exception.ResourceNotFoundException;
import com.capgemini.ECommerceOrderManagementSystem.repository.ShipmentRepository;

import lombok.Data;

@Data
public class ShipmentServiceImpl implements ShipmentService {


	@Override
	public Shipment createShipment(Shipment shipment) {
		return null;
	}

	@Override
	public Shipment getShipmentById(int id) {
		return null;
	}

	@Override
	public List<Shipment> getAllSgipments() {
		return List.of();
	}

	@Override
	public Shipment updateShipment(int id, Shipment shipment) {
		return null;
	}

	@Override
	public void deleteShipment(int id) {

	}
}
