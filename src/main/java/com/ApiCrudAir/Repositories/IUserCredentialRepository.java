package com.ApiCrudAir.Repositories;

import com.ApiCrudAir.models.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserCredentialRepository extends JpaRepository<UserCredential, Long> {

    @Query("SELECT u FROM UserCredential u WHERE u.email = :email")
   UserCredential findByEmail(String email);

}
