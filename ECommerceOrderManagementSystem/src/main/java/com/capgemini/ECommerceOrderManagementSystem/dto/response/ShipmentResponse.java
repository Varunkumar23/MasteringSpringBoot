package com.capgemini.ECommerceOrderManagementSystem.dto.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class ShipmentResponse {
    private int id;
    private String trackingNumber;
    private String status;
    private String customerEmail;
    private String warehouseName;
}
