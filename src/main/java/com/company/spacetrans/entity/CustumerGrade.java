package com.company.spacetrans.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum CustumerGrade implements EnumClass<Integer> {

    BRONZE(10),
    SILVER(20),
    GOLD(10);

    private Integer id;

    CustumerGrade(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static CustumerGrade fromId(Integer id) {
        for (CustumerGrade at : CustumerGrade.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}