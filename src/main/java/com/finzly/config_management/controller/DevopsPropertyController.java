package com.finzly.config_management.controller;

import com.finzly.config_management.DTO.PropertyDTO;
import com.finzly.config_management.DTO.ResponseDTO;
import com.finzly.config_management.DTO.SavePropertyDTO;
import com.finzly.config_management.service.DevopsPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DevopsPropertyController {
    @Autowired
    DevopsPropertyService devopsPropertyService;

    @GetMapping("/tenant-env-properties/{tenantId}/{environmentId}")
    public ResponseEntity<ApiResponse<List<PropertyDTO>>> getProperties(
            @PathVariable String tenantId,
            @PathVariable String environmentId
    ) {
        return devopsPropertyService.getProperties(tenantId, environmentId);
    }

    @DeleteMapping("config-server/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProperty(@PathVariable Long id) {
        try {
            return devopsPropertyService.deletePropertyById(id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse<>(e.getMessage(), 500));
        }
    }


    @PutMapping("config-server")
    public ResponseEntity<ApiResponse<Void>> updateProperty(@RequestBody PropertyDTO propertyDTO) {
        try {
            return devopsPropertyService.updateProperty(propertyDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse<>(e.getMessage(), 500));
        }
    }

    @PostMapping("config-server")
    public ResponseEntity<ApiResponse<Void>> saveProperty(@RequestBody SavePropertyDTO property) {
        try {
            return devopsPropertyService.saveProperty(property);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse<>(e.getMessage(), 500));
        }
    }
}
