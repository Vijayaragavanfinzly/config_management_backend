package com.finzly.config_management.Repository;


import com.finzly.config_management.model.DevopsProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevopsPropertyRepo extends JpaRepository<DevopsProperty,Long> {
    Optional<List<DevopsProperty>> findByTenantIdAndEnvironmentId(String tenantId, String environmentId);
}
