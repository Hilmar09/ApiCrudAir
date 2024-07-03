package com.ApiCrudAir.Repositories;

import com.ApiCrudAir.models.AppAir;
import org.springframework.data.repository.CrudRepository;

public interface IAirRepository extends CrudRepository<AppAir, Integer> {
}
