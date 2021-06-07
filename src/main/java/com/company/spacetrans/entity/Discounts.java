package com.company.spacetrans.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Table(name = "DISCOUNTS")
@Entity
public class Discounts {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "GRADE")
    private Integer grade;

    @Column(name = "VALUE_", precision = 19, scale = 2)
    private BigDecimal value;

    public CustumerGrade getGrade() {
        return grade == null ? null : CustumerGrade.fromId(grade);
    }

    public void setGrade(CustumerGrade grade) {
        this.grade = grade == null ? null : grade.getId();
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}