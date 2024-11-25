package com.finzly.config_management.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tenant_env")

public class TenantEnv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tenant_id")
    private Tenant tenant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="env_id", nullable = false)
    private Environment environment;

    public TenantEnv() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "status")
    private String status;

    public TenantEnv(Long id, Tenant tenant, Environment environment, String status) {
        this.id = id;
        this.tenant = tenant;
        this.environment = environment;
        this.status = status;
    }
}
