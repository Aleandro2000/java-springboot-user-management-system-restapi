package com.usermanagement.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usermanagement.project.models.UserModel;
import com.usermanagement.project.payload.ApiResponse;
import com.usermanagement.project.services.UserServices;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/public/api/v1/user")
public class UserControllerPublic {

    private final UserServices userServices;

    @Autowired
    public UserControllerPublic(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("list")
    public ResponseEntity<ApiResponse<List<UserModel>>> listUsers() {
        List<UserModel> users = userServices.getAllUsers();
        return ResponseEntity.ok(new ApiResponse<>(true, "Users retrieved successfully", users));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<UserModel>> getUserById(@PathVariable Long id) {
        return userServices.getUserById(id)
                .map(user -> ResponseEntity.ok(new ApiResponse<>(true, "User retrieved successfully", user)))
                .orElse(ResponseEntity.status(404).body(new ApiResponse<>(false, "User not found", null)));
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse<UserModel>> createUser(@RequestBody @Valid UserModel entity) {
        UserModel createdUser = userServices.createUser(entity);
        return ResponseEntity.ok(new ApiResponse<>(true, "User created successfully", createdUser));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ApiResponse<UserModel>> updateUser(@PathVariable Long id, @RequestBody @Valid UserModel entity) {
        UserModel updatedUser = userServices.updateUser(id, entity);
        return ResponseEntity.ok(new ApiResponse<>(true, "User updated successfully", updatedUser));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "User deleted successfully", null));
    }
}
