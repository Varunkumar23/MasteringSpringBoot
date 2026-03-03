package com.capgemini.ECommerceOrderManagementSystem.service;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.WarehouseRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.WarehouseResponse;
import com.capgemini.ECommerceOrderManagementSystem.entity.Warehouse;
import com.capgemini.ECommerceOrderManagementSystem.repository.WarehouseRepository;

import java.util.List;

public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;


    @Override
    public WarehouseResponse createWarehouse(WarehouseRequest request) {
        Warehouse warehouse=Warehouse.builder().name(request.getName()).location(request.getLocation()).capacity(request.getCapacity()).build();
        Warehouse saved=warehouseRepository.save(warehouse);

    }

    @Override
    public WarehouseResponse getWarehouseById(Long id) {
        return null;
    }

    @Override
    public List<WarehouseResponse> getAllWarehouses() {
        return List.of();
    }

    @Override
    public WarehouseResponse updateWarehouse(Long id, WarehouseRequest request) {
        return null;
    }

    @Override
    public void deleteWarehouse(Long id) {

    }
}
