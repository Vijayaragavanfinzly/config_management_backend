package com.finzly.config_management.DTO;

public class PropertyDTO {
    private Long id;
    private String propertyKey;
    private String propertyValue;

    public PropertyDTO(Long id,String propertyKey, String propertyValue) {
        this.id=id;
        this.propertyKey = propertyKey;
        this.propertyValue = propertyValue;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
