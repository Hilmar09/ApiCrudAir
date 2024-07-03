package com.ApiCrudAir.Controllers;

import com.ApiCrudAir.models.AppAir;
import com.ApiCrudAir.service.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AirController {

    @Autowired
    AirService airService;

    @DeleteMapping(path = "/appAir")
    public void deleteAllService(){
        airService.deleteAllAppAir();
    }

    @DeleteMapping (path = "/appAir/{id}")
    public void deleteAppAirById(int id){
        airService.deleteAppAirById(id);
    }


}
