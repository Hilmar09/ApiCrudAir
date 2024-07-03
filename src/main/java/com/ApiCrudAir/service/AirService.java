package com.ApiCrudAir.service;

import com.ApiCrudAir.Repositories.IAirRepository;
import com.ApiCrudAir.models.AppAir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirService {

    @Autowired
    IAirRepository iAirRepositoryRepository;


    public void deleteAllAppAir() {
        iAirRepositoryRepository.deleteAll();
    }

    public void deleteAppAirById(int id) {
        iAirRepositoryRepository.deleteById(id);
    }



}
