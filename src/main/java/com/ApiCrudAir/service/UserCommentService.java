package com.ApiCrudAir.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiCrudAir.Repositories.IUserCommentRepository;
import com.ApiCrudAir.models.UserCommentModel;

@Service
public class UserCommentService {

    @Autowired
    IUserCommentRepository userCommentRepository;

    public ArrayList<UserCommentModel> getUsersCommentByUser(Long user) {
        return (ArrayList<UserCommentModel>) userCommentRepository.findByUser(user);
    }

    public UserCommentModel saveCommentUser(UserCommentModel user) {
        return userCommentRepository.save(user);
    }
}
