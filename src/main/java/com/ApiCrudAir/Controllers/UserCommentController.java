package com.ApiCrudAir.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiCrudAir.models.UserCommentModel;
import com.ApiCrudAir.models.UserModel;
import com.ApiCrudAir.service.UserCommentService;

@RestController
@RequestMapping("/comment")
public class UserCommentController {

    @Autowired
    private UserCommentService userCommentService;

    @GetMapping
    public ArrayList<UserCommentModel> getCommentRandom(){
        return this.userCommentService.getCommentRandom();
    }

    @GetMapping("/{user}")
    public ArrayList<UserCommentModel> getUsersCommentByUser(@PathVariable("user") Long user) {
        return this.userCommentService.getUsersCommentByUser(user);
    }

    @PutMapping()
    public UserCommentModel updateUserModel(@RequestBody UserCommentModel user) {
        return this.userCommentService.updateUserCommitById(user);
    }


    @PostMapping
    public UserCommentModel saveCommentUser(@RequestBody UserCommentModel user) {
        return this.userCommentService.saveCommentUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserComment(@PathVariable("id") Long id) {
        boolean ok = this.userCommentService.deleteUserComment(id);

        if (ok)
            return "User Comment as deleted";
        else
            return "Error, we have a problem to deleted user Comment";
    }
}