package com.lpu.UserManagementSystem.service;

import com.lpu.UserManagementSystem.dto.UserRequest;
import com.lpu.UserManagementSystem.dto.UserResponse;
import com.lpu.UserManagementSystem.entity.User;
import com.lpu.UserManagementSystem.exception.DuplicateUserException;
import com.lpu.UserManagementSystem.exception.UserNotFoundException;
import com.lpu.UserManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public UserResponse createUser(UserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateUserException("User already exists with this mail!");
        }
        User user = modelMapper.map(request, User.class);
        User saved = userRepository.save(user);
        return modelMapper.map(saved, UserResponse.class);
    }

    @Override
    public UserResponse getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return modelMapper.map(user, UserResponse.class);

    }

    @Override
    public Page<UserResponse> getAllUsers(int page, int size, String sortBy) {
//        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC,sortBy));

        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(user -> modelMapper.map(user, UserResponse.class));

    }

    @Override
    public UserResponse updateUser(int id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        User updatedUser = userRepository.save(user);

        return modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    public void deleteUser(int id) {

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }

    @Override
    public UserResponse findByName(String name) {
        User user = userRepository.findByName(name).orElseThrow(() -> new UserNotFoundException("User not found with the given name: " + name));

        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found with the given email: " + email));

        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUsersByRole(String role) {
        return userRepository.getUsersByRole(role).stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
    }

    public List<UserResponse> getUsersContainInName(String ch) {
        return userRepository.getUsersContainInName(ch).stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
    }

    public List<UserResponse> fetchUsersBySorting(String field, String direction) {
        return userRepository.findAll(Sort.by(direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, field)).stream().map(user -> modelMapper.map(user, UserResponse.class)).toList();
    }


}
