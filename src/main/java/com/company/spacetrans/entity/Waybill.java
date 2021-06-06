package com.company.spacetrans.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "WAYBILL")
@Entity
public class Waybill {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "REFERENCE")
    private String reference;

    @JoinColumn(name = "CREATOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

    @JoinColumn(name = "SHIPPER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer shipper;

    @JoinColumn(name = "CONSIGNEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer consignee;

    @JoinColumn(name = "DEPARTURE_PORT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Spaceport departurePort;

    @JoinColumn(name = "DESTINATION_PORT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Spaceport destinationPort;

    @JoinColumn(name = "CARRIER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Carrier carrier;

    @Composition
    @OneToMany(mappedBy = "waybill")
    private List<WaybillItem> items;

    @Column(name = "TOTAL_WEIGHT")
    private Double totalWeight;

    @Column(name = "TOTAL_CHARGE")
    private Double totalCharge;

    public Double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(Double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Customer getConsignee() {
        return consignee;
    }

    public void setConsignee(Customer consignee) {
        this.consignee = consignee;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Customer getShipper() {
        return shipper;
    }

    public void setShipper(Customer shipper) {
        this.shipper = shipper;
    }

    public List<WaybillItem> getItems() {
        return items;
    }

    public void setItems(List<WaybillItem> items) {
        this.items = items;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public Spaceport getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(Spaceport destinationPort) {
        this.destinationPort = destinationPort;
    }

    public Spaceport getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(Spaceport departurePort) {
        this.departurePort = departurePort;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}