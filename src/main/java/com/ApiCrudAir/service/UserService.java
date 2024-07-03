package com.ApiCrudAir.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiCrudAir.Repositories.IUserRepository;
import com.ApiCrudAir.models.UserModel;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id) {
        UserModel user = userRepository.findById(id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        return user;
    }

}
