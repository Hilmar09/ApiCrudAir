package com.ApiCrudAir.Controllers;

import com.ApiCrudAir.models.UserCredential;
import com.ApiCrudAir.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/credential")
public class UserCredentialController {

    @Autowired
    private UserCredentialService userCredentialService;

    @GetMapping
    public ArrayList<UserCredential> getUserCredential(){
        return this.userCredentialService.getUserCredential();
    }

    @PutMapping("/{id}")
    public UserCredential updatUserCredential(@RequestBody UserCredential credential, @PathVariable Long id) {
        return this.userCredentialService.updateById(credential, id);
    }

    @PostMapping("/login")
    public UserCredential login(@RequestParam String email, @RequestParam String password) {
        return userCredentialService.credentialUser(email, password);
 }

    @PostMapping
    public UserCredential createUserCredential(@RequestBody UserCredential credential) {
        return userCredentialService.createUserCredential(credential);
    }
}