package com.finzly.config_management.controller;

import com.finzly.config_management.Repository.TenantEnvRepo;
import com.finzly.config_management.model.Environment;
import com.finzly.config_management.model.TenantEnv;
import com.finzly.config_management.service.TenantEnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class TenantEnvController {

    @Autowired
    TenantEnvService tenantEnvService;

    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<Object> getEnvironmentsByTenantId(@PathVariable String tenantId) {

        List<Environment> tenantEnvironments = tenantEnvService.getEnvironmentsByTenantId(tenantId);
        if (tenantEnvironments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No environments found for tenant ID: " + tenantId);
        }
        return ResponseEntity.ok(tenantEnvironments);
    }
}
