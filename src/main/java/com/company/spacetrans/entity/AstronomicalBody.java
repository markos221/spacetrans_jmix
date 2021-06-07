package com.company.spacetrans.entity;

import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.PropertyDatatype;

import javax.persistence.*;
import java.io.FileDescriptor;
import java.util.UUID;

@JmixEntity
@MappedSuperclass
public class AstronomicalBody {

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "MASS")
    private Double mass;

    @PropertyDatatype("fileRef")
    @Column(name = "IMAGE")
    private FileRef picture;

    public FileRef getPicture() {
        return picture;
    }

    public void setPicture(FileRef picture) {
        this.picture = picture;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}