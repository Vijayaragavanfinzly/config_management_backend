package com.finzly.config_management.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "environment")
public class Environment {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "environment_name")
    private String environmentName;

    @Column(name = "status")
    private String status;

    // Constructors
    public Environment() {}

    public Environment(String id, String environmentName, String status) {
        this.id = id;
        this.environmentName = environmentName;
        this.status = status;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "Environment{" +
                "id='" + id + '\'' +
                ", environmentName='" + environmentName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

