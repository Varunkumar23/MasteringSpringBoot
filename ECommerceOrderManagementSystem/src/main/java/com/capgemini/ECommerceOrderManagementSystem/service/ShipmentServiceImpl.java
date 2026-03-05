package com.capgemini.ECommerceOrderManagementSystem.service;

import java.util.List;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.ShipmentRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.ShipmentResponse;
import com.capgemini.ECommerceOrderManagementSystem.entity.Warehouse;
import com.capgemini.ECommerceOrderManagementSystem.repository.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.ECommerceOrderManagementSystem.entity.Shipment;
import com.capgemini.ECommerceOrderManagementSystem.exception.ResourceNotFoundException;
import com.capgemini.ECommerceOrderManagementSystem.repository.ShipmentRepository;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShipmentResponse createShipment(@RequestBody ShipmentRequest shipmentRequest) {
        Warehouse warehouse = warehouseRepository.findById(shipmentRequest.getWarehouseId())
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));

        Shipment shipment = modelMapper.map(shipmentRequest, Shipment.class);
        shipment.setWarehouse(warehouse);

        Shipment saved = shipmentRepository.save(shipment);

        return modelMapper.map(saved,ShipmentResponse.class);


    }

    @Override
    public ShipmentResponse getShipmentById(int id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        return modelMapper.map(shipment, ShipmentResponse.class);
    }

    @Override
    public List<ShipmentResponse> getAllShipments() {
        return shipmentRepository.findAll().stream().map(shipment -> modelMapper.map(shipment, ShipmentResponse.class)).toList();
    }

    @Override
    public ShipmentResponse updateShipment(int id, ShipmentRequest shipmentRequest) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        if (shipmentRequest.getStatus() != null) {
            shipment.setStatus(shipmentRequest.getStatus());
        }

        if (shipmentRequest.getCustomerEmail() != null) {
            shipment.setCustomerEmail(shipmentRequest.getCustomerEmail());
        }

        Shipment updated = shipmentRepository.save(shipment);

        return modelMapper.map(updated, ShipmentResponse.class);
    }

    @Override
    public String deleteShipment(int id) {
        if (!shipmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Shipment not found");
        }
        shipmentRepository.deleteById(id);
        return "Shipment deleted successfully!";
    }
}
