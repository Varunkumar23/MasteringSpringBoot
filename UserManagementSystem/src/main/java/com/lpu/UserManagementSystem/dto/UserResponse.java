package com.lpu.UserManagementSystem.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class UserResponse {

    private int id;

    private String name;

    private String email;

    private String role;

}