package com.finzly.config_management.service;

import com.finzly.config_management.Repository.TenantEnvRepo;
import com.finzly.config_management.model.Environment;
import com.finzly.config_management.model.TenantEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenantEnvService {

    @Autowired
    private TenantEnvRepo tenantEnvRepo;

    public List<Environment> getEnvironmentsByTenantId(String tenantId) {
        List<Environment> EnvironmentList=new ArrayList<>();
        List<TenantEnv> tenantEnv=tenantEnvRepo.findByTenantId(tenantId);
        tenantEnv.forEach(x->EnvironmentList.add(x.getEnvironment()));
        return EnvironmentList;
    }

}
