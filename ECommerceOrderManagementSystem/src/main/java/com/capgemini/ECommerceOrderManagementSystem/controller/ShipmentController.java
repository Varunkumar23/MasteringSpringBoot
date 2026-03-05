package com.capgemini.ECommerceOrderManagementSystem.controller;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.ShipmentRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.ShipmentResponse;
import com.capgemini.ECommerceOrderManagementSystem.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public ShipmentResponse createShipment(@Valid @RequestBody ShipmentRequest request) {

        return shipmentService.createShipment(request);
    }

    @GetMapping("/{id}")
    public ShipmentResponse getShipmentById(@PathVariable int id) {

        return shipmentService.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentResponse> getAllShipments() {

        return shipmentService.getAllShipments();
    }

    @PatchMapping("/{id}")
    public ShipmentResponse updateShipment(@PathVariable int id, @RequestBody ShipmentRequest request) {

        return shipmentService.updateShipment(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteShipment(@PathVariable int id) {
        return shipmentService.deleteShipment(id);
    }
}
