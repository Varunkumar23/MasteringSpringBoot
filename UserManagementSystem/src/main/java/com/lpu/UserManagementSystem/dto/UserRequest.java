package com.lpu.UserManagementSystem.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class UserRequest {

    private String name;

    private String email;

    private String password;

    private String role;

}