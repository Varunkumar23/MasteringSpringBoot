package com.capgemini.ECommerceOrderManagementSystem.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseRequest {

    @Size(min = 3, max = 50)
    private String name;

    @Size(min = 3, max = 50)
    private String location;

    @Positive
    private int capacity;
}
