package com.ApiCrudAir.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiCrudAir.Repositories.IUserRepository;
import com.ApiCrudAir.models.UserModel;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){ 
        return (ArrayList<UserModel>) userRepository.findAll();
    }

}
