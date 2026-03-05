package com.capgemini.ECommerceOrderManagementSystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class ShipmentRequest {
    @NotNull
    private int warehouseId;

    @NotBlank
    private String trackingNumber;

    @Email
    @NotBlank
    private String customerEmail;

    @NotNull
    private String status;
}
