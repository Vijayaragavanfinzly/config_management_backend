package com.finzly.config_management.service;

import com.finzly.config_management.DTO.SavePropertyDTO;
import com.finzly.config_management.Repository.DevopsPropertyRepo;
import com.finzly.config_management.Repository.EnvironmentRepo;
import com.finzly.config_management.Repository.TenantRepo;
import com.finzly.config_management.controller.ApiResponse;
import com.finzly.config_management.model.DevopsProperty;
import com.finzly.config_management.DTO.PropertyDTO;
import com.finzly.config_management.DTO.ResponseDTO;
import com.finzly.config_management.model.Environment;
import com.finzly.config_management.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DevopsPropertyService {

    @Autowired
    DevopsPropertyRepo devopsPropertyRepo;

    @Autowired
    EnvironmentRepo environmentRepo;

    @Autowired
    TenantRepo tenantRepo;

    public ResponseEntity<ApiResponse<List<PropertyDTO>>> getProperties(String tenantId, String environmentId) {
        List<PropertyDTO> propertyList = new ArrayList<>();
        Optional<List<DevopsProperty>> existingProperties = devopsPropertyRepo.findByTenantIdAndEnvironmentId(tenantId, environmentId);

        if (existingProperties.isPresent() && !existingProperties.get().isEmpty()) {
            List<DevopsProperty> properties = existingProperties.get();
            properties.forEach(x -> propertyList.add(new PropertyDTO(x.getId(), x.getPropertyKey(), x.getPropertyValue())));
            return ResponseEntity.ok(new ApiResponse<>("Properties fetched successfully", HttpStatus.OK.value(), propertyList));
        } else {
            return ResponseEntity.ok(new ApiResponse<>("No properties found", HttpStatus.OK.value(), new ArrayList<>()));
        }
    }

    public ResponseEntity<ApiResponse<Void>> deletePropertyById(Long id) {
        Optional<DevopsProperty> property = devopsPropertyRepo.findById(id);
        if (property.isPresent()) {
            devopsPropertyRepo.deleteById(id);
            return ResponseEntity.ok(new ApiResponse<>("Property deleted successfully.", HttpStatus.OK.value()));
        } else {
            return ResponseEntity.ok(new ApiResponse<>("No property found with the provided ID.", HttpStatus.NOT_FOUND.value()));
        }
    }


    public ResponseEntity<ApiResponse<Void>> updateProperty(PropertyDTO propertyDTO) {
        Optional<DevopsProperty> property = devopsPropertyRepo.findById(propertyDTO.getId());
        if (property.isPresent()) {
            DevopsProperty updatedProperty = property.get();
            updatedProperty.setPropertyKey(propertyDTO.getPropertyKey());
            updatedProperty.setPropertyValue(propertyDTO.getPropertyValue());
            updatedProperty.setUpdatedAt(LocalDateTime.now());
            devopsPropertyRepo.save(updatedProperty);

            return ResponseEntity.ok(new ApiResponse<>("Property updated successfully.", HttpStatus.OK.value()));
        } else {
            return ResponseEntity.ok(new ApiResponse<>("No property found with the provided ID.", HttpStatus.NOT_FOUND.value()));
        }
    }


    public ResponseEntity<ApiResponse<Void>> saveProperty(SavePropertyDTO propertyDTO) {
        try {
            DevopsProperty devopsProperty = new DevopsProperty();
            devopsProperty.setPropertyKey(propertyDTO.getPropertyKey());
            devopsProperty.setPropertyValue(propertyDTO.getPropertyValue());
            devopsProperty.setCreatedAt(LocalDateTime.now());
            devopsProperty.setUpdatedAt(LocalDateTime.now());

            Optional<Environment> environment = environmentRepo.findById(propertyDTO.getEnvironmentName());
            if (environment.isPresent()) {
                devopsProperty.setEnvironment(environment.get());
            } else {
                return ResponseEntity.ok(new ApiResponse<>("No Environment found with the provided ID.", HttpStatus.NOT_FOUND.value()));
            }

            Optional<Tenant> tenant = tenantRepo.findById(propertyDTO.getTenantName());
            if (tenant.isPresent()) {
                devopsProperty.setTenant(tenant.get());
            } else {
                return ResponseEntity.ok(new ApiResponse<>("No Tenant found with the provided ID.", HttpStatus.NOT_FOUND.value()));
            }

            devopsPropertyRepo.save(devopsProperty);
            return ResponseEntity.ok(new ApiResponse<>("Property saved successfully!", HttpStatus.CREATED.value()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>("Error occurred while saving property: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }
}
