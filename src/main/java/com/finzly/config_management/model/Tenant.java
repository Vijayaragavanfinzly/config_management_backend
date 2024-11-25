package com.finzly.config_management.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tenant")
public class Tenant {
    @Id
    private String id;

    @Column(name = "tenant_name")
    private String tenantName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "description")
    private String description;

    @Column(name="status")
    private String status;

    @OneToMany(mappedBy = "tenant", fetch = FetchType.EAGER)
    private List<TenantEnv> tenantEnvironments;

    // Constructors, Getters, and Setters
    public Tenant() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
