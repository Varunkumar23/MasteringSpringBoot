package com.capgemini.ECommerceOrderManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ECommerceOrderManagementSystem.entity.TrackingEvent;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Integer> {

}
