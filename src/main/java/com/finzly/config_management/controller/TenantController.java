package com.finzly.config_management.controller;


import com.finzly.config_management.model.Environment;
import com.finzly.config_management.model.Tenant;
import com.finzly.config_management.service.EnvironmentService;
import com.finzly.config_management.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class TenantController {


    @Autowired
    TenantService tenantService;

    @GetMapping("/tenants")
    public ResponseEntity<List<Tenant>> getTenants(){
        List<Tenant>  tenants =  tenantService.getTenants();
        return ResponseEntity.ok(tenants);
    }

}
