package com.finzly.config_management.Repository;

import com.finzly.config_management.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepo extends JpaRepository<Tenant,String> {
}
