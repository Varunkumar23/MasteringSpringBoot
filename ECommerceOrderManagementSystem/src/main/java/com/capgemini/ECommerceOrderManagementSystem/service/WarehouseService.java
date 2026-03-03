package com.capgemini.ECommerceOrderManagementSystem.service;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.WarehouseRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.WarehouseResponse;

import java.util.List;

public interface WarehouseService {
    WarehouseResponse createWarehouse(WarehouseRequest request);

    WarehouseResponse getWarehouseById(Long id);

    List<WarehouseResponse> getAllWarehouses();

    WarehouseResponse updateWarehouse(Long id, WarehouseRequest request);

    void deleteWarehouse(Long id);
}
