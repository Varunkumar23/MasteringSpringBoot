package com.capgemini.ECommerceOrderManagementSystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateTrackingEventRequest {
    @NotNull
    @Positive
    private Long warehouseId;

    @NotNull
    @Size(min = 3, max = 50)
    private String trackingNumber;

    @Email
    @NotNull
    private String customerEmail;

    @NotNull
    private String status;
}
