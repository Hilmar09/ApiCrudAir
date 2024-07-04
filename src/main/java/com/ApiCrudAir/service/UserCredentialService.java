package com.ApiCrudAir.service;

import com.ApiCrudAir.Repositories.IUserCredentialRepository;
import com.ApiCrudAir.models.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserCredentialService {

    @Autowired
    private IUserCredentialRepository userCredentialRepository;

    public ArrayList<UserCredential> getUserCredential() {
        return (ArrayList<UserCredential>) userCredentialRepository.findAll();
    }

    public UserCredential credentialUser(String email, String password) {
        UserCredential user = userCredentialRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    public UserCredential updateById(UserCredential request, Long id) {
        Optional<UserCredential> optionalCredential = userCredentialRepository.findById(id);

        if (optionalCredential.isPresent()) {
            UserCredential credential = optionalCredential.get();

            credential.setEmail(request.getEmail());
            credential.setPassword(request.getPassword());

            return userCredentialRepository.save(credential);
        } else {
            return null;
        }
    }

    public UserCredential createUserCredential(UserCredential credential) {
        return userCredentialRepository.save(credential);
    }
}
