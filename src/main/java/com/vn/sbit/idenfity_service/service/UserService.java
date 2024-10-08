package com.vn.sbit.idenfity_service.service;

import com.vn.sbit.idenfity_service.dto.request.UserCreationRequest;
import com.vn.sbit.idenfity_service.dto.request.UserUpdateRequest;
import com.vn.sbit.idenfity_service.entity.User;
import com.vn.sbit.idenfity_service.exception.AppException;
import com.vn.sbit.idenfity_service.exception.ErrorCode;
import com.vn.sbit.idenfity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request){
        User user = new User();
        if(userRepository.existsByUserName(request.getUserName())
        ) throw new AppException(ErrorCode.USER_EXISTED);

        user.setUserName(request.getUserName());
        user.setPassWord(request.getPassWord());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }
    public List<User> getUsers(){
      return  userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id)
                .orElseThrow(()->new  RuntimeException("User not found")
        );
    }


    public User updateUser(String userId,UserUpdateRequest request) {
        User user = getUser(userId);

        user.setPassWord(request.getPassWord());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return  userRepository.save(user);
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);

    }
}
