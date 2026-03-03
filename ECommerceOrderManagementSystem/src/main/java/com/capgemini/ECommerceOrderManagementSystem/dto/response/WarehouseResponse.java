package com.capgemini.ECommerceOrderManagementSystem.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseResponse {

    private int id;
    private String name;
    private String location;
    private int capacity;
}
