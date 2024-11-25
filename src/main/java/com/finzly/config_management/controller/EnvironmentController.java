package com.finzly.config_management.controller;

import com.finzly.config_management.model.Environment;
import com.finzly.config_management.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class EnvironmentController {

    @Autowired
    EnvironmentService environmentService;

    @GetMapping("/environments")
    public ResponseEntity<List<Environment>> getEnvironments(){
           List<Environment>  environments =  environmentService.getEnvironments();
           return ResponseEntity.ok(environments);
    }
}
