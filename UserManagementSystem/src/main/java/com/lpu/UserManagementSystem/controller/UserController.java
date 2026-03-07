package com.lpu.UserManagementSystem.controller;

import com.lpu.UserManagementSystem.dto.ApiResponse;
import com.lpu.UserManagementSystem.dto.UserRequest;
import com.lpu.UserManagementSystem.dto.UserResponse;
import com.lpu.UserManagementSystem.entity.User;
import com.lpu.UserManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest request) {

        UserResponse response = userService.createUser(request);

        ApiResponse<UserResponse> apiResponse =
                new ApiResponse<>(true, "User creation successful!", response);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(apiResponse);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable int id) {
        UserResponse response = userService.getUserById(id);
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>(true, "User with id " + id + " found", response);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/all")
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

    @GetMapping("name/{name}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserByName(@PathVariable String name){
        UserResponse response=userService.findByName(name);
        ApiResponse<UserResponse> apiResponse=new ApiResponse<>(true,"Found a user with name: "+name,response);
        return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserByEmail(@PathVariable String email){
        UserResponse response=userService.findByEmail(email);
        ApiResponse<UserResponse> apiResponse=new ApiResponse<>(true,"Found a user with email: "+email,response);
        return ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
    }

    @GetMapping("role/{role}")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getUsersByRole(@PathVariable String role){
        List<UserResponse> response=userService.getAllUsersByRole(role);
        ApiResponse<List<UserResponse>> apiResponse=new ApiResponse<>(true,"Found all the users with role: "+role,response);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }

    @GetMapping("/contains/{ch}")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getUsersContainInName(@PathVariable String ch){
        List<UserResponse> list=userService.getUsersContainInName(ch);
        ApiResponse<List<UserResponse>> apiResponse;
        if(!list.isEmpty()){
             apiResponse=new ApiResponse<>(true,"Found All The Users Containing  "+ch+" In Their Name",list);
        }else{
            apiResponse=new ApiResponse<>(true,"No Users Found Who Contains "+ch+" In Their Name",null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }


}
