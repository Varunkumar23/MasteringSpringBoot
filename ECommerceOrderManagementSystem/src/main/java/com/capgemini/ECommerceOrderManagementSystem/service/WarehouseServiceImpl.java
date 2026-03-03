package com.capgemini.ECommerceOrderManagementSystem.service;

import com.capgemini.ECommerceOrderManagementSystem.dto.request.WarehouseRequest;
import com.capgemini.ECommerceOrderManagementSystem.dto.response.WarehouseResponse;
import com.capgemini.ECommerceOrderManagementSystem.entity.Warehouse;
import com.capgemini.ECommerceOrderManagementSystem.exception.ResourceNotFoundException;
import com.capgemini.ECommerceOrderManagementSystem.repository.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public WarehouseResponse createWarehouse(WarehouseRequest request) {
        Warehouse warehouse = modelMapper.map(request, Warehouse.class);
        Warehouse saved = warehouseRepository.save(warehouse);
        WarehouseResponse warehouseResponse = new WarehouseResponse();
        warehouseResponse.setId(saved.getId());
        warehouseResponse.setName(saved.getName());
        warehouseResponse.setLocation(saved.getLocation());
        warehouseResponse.setCapacity(saved.getCapacity());
        return warehouseResponse;

    }

    @Override
    public WarehouseResponse getWarehouseById(int id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));
        WarehouseResponse warehouseResponse = new WarehouseResponse();
        warehouseResponse.setId(warehouse.getId());
        warehouseResponse.setName(warehouse.getName());
        warehouseResponse.setLocation(warehouse.getLocation());
        warehouseResponse.setCapacity(warehouse.getCapacity());
        return warehouseResponse;
    }

    @Override
    public List<WarehouseResponse> getAllWarehouses() {
        return warehouseRepository.findAll().stream().map(warehouse -> modelMapper.map(warehouse, WarehouseResponse.class)).toList();
    }

    @Override
    public WarehouseResponse updateWarehouse(int id, WarehouseRequest request) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found with id: " + id));
        if (request.getName() != null) {
            warehouse.setName(request.getName());
        } else if (request.getCapacity() != null) {
            warehouse.setCapacity(request.getCapacity());
        } else if (request.getLocation() != null) {
            warehouse.setLocation(request.getLocation());
        }
        Warehouse updated = warehouseRepository.save(warehouse);
        return modelMapper.map(updated, WarehouseResponse.class);
    }

    @Override
    public String deleteWarehouse(int id) {
        if (!warehouseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Warehouse not found");

        }
        warehouseRepository.deleteById(id);
        return "Warehouse deleted successfully!";
    }
}
