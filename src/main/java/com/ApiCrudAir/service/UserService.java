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
        //user.setPassword(Integer.toString(user.getPassword().hashCode()));
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request) {
        UserModel user = userRepository.findById(request.getId()).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setAllergic(request.getAllergic());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    public Boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String credentialUser(String email, String password) {
        UserModel user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(Integer.toString(password.hashCode()))) {
            return "Auntenticate";
        } else {
            return null;
        }
    }
}
