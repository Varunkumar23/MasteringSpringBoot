package com.lpu.UserManagementSystem.controller;

import com.lpu.UserManagementSystem.dto.ApiResponse;
import com.lpu.UserManagementSystem.dto.UserRequest;
import com.lpu.UserManagementSystem.dto.UserResponse;
import com.lpu.UserManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest request) {

        UserResponse response = userService.createUser(request);

        ApiResponse<UserResponse> apiResponse =
                new ApiResponse<>(true, "User creation successful!", response);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable int id) {
        UserResponse response = userService.getUserById(id);
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>(true, "User with id " + id + " found", response);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {

        List<UserResponse> list = userService.getAllUsers();

        ApiResponse<List<UserResponse>> apiResponse =
                new ApiResponse<>(true, "Found all the users", list);

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUserById(@PathVariable int id, @RequestBody UserRequest request) {
        UserResponse response = userService.updateUser(id, request);
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>(true, "User Updated Successfully!", response);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable int id) {

        userService.deleteUser(id);

        ApiResponse<String> response =
                new ApiResponse<>(true, "User deleted successfully", null);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
