package com.ApiCrudAir.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiCrudAir.models.UserCommentModel;
import com.ApiCrudAir.service.UserCommentService;

@RestController
@RequestMapping("/comment")
public class UserCommentController {

    @Autowired
    private UserCommentService userCommentService;

    @GetMapping
    public ArrayList<UserCommentModel> getUsersComment() {
        return this.userCommentService.getUsersComment();
    }
}
