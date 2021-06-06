package com.company.spacetrans.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ST_CARRIER")
@Entity
public class Carrier {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @JoinTable(name = "CARRIER_SPACEPORT_LINK",
            joinColumns = @JoinColumn(name = "CARRIER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPACEPORT_ID"))
    @ManyToMany
    private List<Spaceport> ports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Spaceport> getPorts() {
        return ports;
    }

    public void setPorts(List<Spaceport> ports) {
        this.ports = ports;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}