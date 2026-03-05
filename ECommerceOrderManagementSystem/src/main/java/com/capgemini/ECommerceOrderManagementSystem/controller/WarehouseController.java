package com.capgemini.ECommerceOrderManagementSystem.controller;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.WarehouseRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.WarehouseResponse;
import com.capgemini.ECommerceOrderManagementSystem.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<WarehouseResponse> createWarehouse(
            @Valid @RequestBody WarehouseRequest warehouseRequest) {

        WarehouseResponse response = warehouseService.createWarehouse(warehouseRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseResponse> getWarehouseById(@PathVariable int id) {

        return ResponseEntity.status(HttpStatus.OK).body(warehouseService.getWarehouseById(id));
    }

    @GetMapping
    public ResponseEntity<List<WarehouseResponse>> getAllWarehouses() {
        return ResponseEntity.status(HttpStatus.OK).body(warehouseService.getAllWarehouses());
    }

    @PatchMapping("/{id}")
    public WarehouseResponse updateWareHouse(@PathVariable int id, @RequestBody WarehouseRequest request) {
        return warehouseService.updateWarehouse(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteWareHouse(@PathVariable int id) {
        return warehouseService.deleteWarehouse(id);
    }


}
