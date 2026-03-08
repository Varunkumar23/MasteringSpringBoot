package com.lpu.UserManagementSystem.service;

import com.lpu.UserManagementSystem.dto.UserRequest;
import com.lpu.UserManagementSystem.dto.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    UserResponse getUserById(int id);

    Page<UserResponse> getAllUsers(int page,int size,String sortBy);

    UserResponse updateUser(int id, UserRequest request);

    void deleteUser(int id);

    UserResponse findByName(String name);

    UserResponse findByEmail(String email);

    List<UserResponse> getAllUsersByRole(String role);

    List<UserResponse> getUsersContainInName(String ch);

    List<UserResponse> fetchUsersBySorting(String field,String direction);
}
