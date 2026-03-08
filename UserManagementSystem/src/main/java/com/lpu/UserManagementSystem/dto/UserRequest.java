package com.lpu.UserManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class UserRequest {

    @NotBlank(message="User name is required")
    private String name;

    @Email
    @NotBlank(message="User email is required")
    private String email;

    @Size(min=3,max=20)
    private String password;

    @NotBlank(message="User role is required")
    private String role;

}