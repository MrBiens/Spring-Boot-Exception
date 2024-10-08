package com.vn.sbit.idenfity_service.controller;

import com.vn.sbit.idenfity_service.dto.request.ApiResponse;
import com.vn.sbit.idenfity_service.dto.request.UserCreationRequest;
import com.vn.sbit.idenfity_service.dto.request.UserUpdateRequest;
import com.vn.sbit.idenfity_service.entity.User;
import com.vn.sbit.idenfity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    //validation
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> userApiResponse = new ApiResponse<>();

        userApiResponse.setCode(1100);
        userApiResponse.setMessage("Success");
        userApiResponse.setResult(userService.createUser(request));
        return userApiResponse;
    }
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") String userId,@RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
         userService.deleteUser(userId);
         return "User has been deleted";

    }

}
