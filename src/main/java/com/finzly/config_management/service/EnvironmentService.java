package com.finzly.config_management.service;

import com.finzly.config_management.Repository.EnvironmentRepo;
import com.finzly.config_management.model.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentService {

    @Autowired
    EnvironmentRepo environmentRepo;

    public List<Environment> getEnvironments() {
        return environmentRepo.findAll();
    }
}
