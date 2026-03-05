package com.capgemini.ECommerceOrderManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ECommerceOrderManagementSystem.entity.Warehouse;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}
