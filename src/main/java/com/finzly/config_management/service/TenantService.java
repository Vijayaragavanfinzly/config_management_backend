package com.finzly.config_management.service;


import com.finzly.config_management.Repository.TenantRepo;
import com.finzly.config_management.model.Environment;
import com.finzly.config_management.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    @Autowired
    TenantRepo tenantRepo;
    public List<Tenant> getTenants() {
        return tenantRepo.findAll();
    }
}
