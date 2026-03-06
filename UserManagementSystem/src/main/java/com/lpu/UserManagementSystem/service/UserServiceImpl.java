package com.lpu.UserManagementSystem.service;

import com.lpu.UserManagementSystem.dto.UserRequest;
import com.lpu.UserManagementSystem.dto.UserResponse;
import com.lpu.UserManagementSystem.entity.User;
import com.lpu.UserManagementSystem.exception.DuplicateUserException;
import com.lpu.UserManagementSystem.exception.UserNotFoundException;
import com.lpu.UserManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    @Override
    public UserResponse createUser(UserRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            throw new DuplicateUserException("User already exists with this mail!");
        }
        User user= modelMapper.map(request,User.class);
        User saved=userRepository.save(user);
        return modelMapper.map(saved,UserResponse.class);
    }

    @Override
    public UserResponse getUserById(int id) {
        User user= userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: " + id));
        return modelMapper.map(user,UserResponse.class);

    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserResponse.class)).toList();
    }

    @Override
    public UserResponse updateUser(int id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        User updatedUser = userRepository.save(user);

        return modelMapper.map(updatedUser, UserResponse.class);
    }

    @Override
    public void deleteUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }
}
