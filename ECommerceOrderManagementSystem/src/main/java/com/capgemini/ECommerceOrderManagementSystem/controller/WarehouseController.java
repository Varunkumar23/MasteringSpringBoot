package com.capgemini.ECommerceOrderManagementSystem.controller;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.WarehouseRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.WarehouseResponse;
import com.capgemini.ECommerceOrderManagementSystem.service.WarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public WarehouseResponse createWarehouse(@Valid @RequestBody WarehouseRequest warehouseRequest) {
        return warehouseService.createWarehouse(warehouseRequest);
    }

    @GetMapping("/{id}")
    public WarehouseResponse getWarehouseById(@PathVariable int id) {
        return warehouseService.getWarehouseById(id);
    }

    @GetMapping
    public List<WarehouseResponse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
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
