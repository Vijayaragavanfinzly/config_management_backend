package com.finzly.config_management.Repository;

import com.finzly.config_management.model.TenantEnv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TenantEnvRepo extends JpaRepository<TenantEnv, Long> {
    List<TenantEnv> findByTenantId(String tenantId);
}
