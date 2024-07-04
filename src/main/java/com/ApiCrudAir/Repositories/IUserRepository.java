package com.ApiCrudAir.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApiCrudAir.models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);

}