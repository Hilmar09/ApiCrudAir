package com.ApiCrudAir.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApiCrudAir.models.UserCommentModel;

@Repository
public interface IUserCommentRepository extends JpaRepository<UserCommentModel, Long>{

}
