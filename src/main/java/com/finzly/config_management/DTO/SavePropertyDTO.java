package com.finzly.config_management.DTO;

public class SavePropertyDTO {
    private String tenantName;
    private String environmentName;
    private String propertyKey;
    private String propertyValue;


    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }



    public SavePropertyDTO(String tenantName, String environmentName, String propertyKey, String propertyValue) {
        this.tenantName = tenantName;
        this.environmentName = environmentName;
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
    }


    public SavePropertyDTO() {
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }


}
