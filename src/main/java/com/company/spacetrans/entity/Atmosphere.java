package com.company.spacetrans.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ATMOSPHERE")
@Entity
public class Atmosphere {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRESSURE")
    private Double pressure;

    @Composition
    @OneToMany(mappedBy = "atmosphere")
    private List<AtmosphericGas> gases;

    public List<AtmosphericGas> getGases() {
        return gases;
    }

    public void setGases(List<AtmosphericGas> gases) {
        this.gases = gases;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}