package com.capgemini.ECommerceOrderManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ECommerceOrderManagementSystem.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}
