package com.company.spacetrans.entity;

import io.jmix.core.entity.annotation.EmbeddedParameters;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Table(name = "WAYBILL_ITEM")
@Entity
public class WaybillItem {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @PositiveOrZero
    @Column(name = "NUMBER_")
    private Integer number;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "WEIGHT")
    private Double weight;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "length", column = @Column(name = "DIM_LENGTH")),
            @AttributeOverride(name = "width", column = @Column(name = "DIM_WIDTH")),
            @AttributeOverride(name = "height", column = @Column(name = "DIM_HEIGHT"))
    })
    private Dimensions dim;

    @JoinColumn(name = "WAYBILL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Waybill waybill;

    @Column(name = "CHARGE")
    private BigDecimal charge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Dimensions getDim() {
        return dim;
    }

    public void setDim(Dimensions dim) {
        this.dim = dim;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }

    public Integer getNumber() {
        return number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}