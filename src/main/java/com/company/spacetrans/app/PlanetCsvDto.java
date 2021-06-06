package com.company.spacetrans.app;

import com.opencsv.bean.CsvBindByPosition;

public class PlanetCsvDto {
    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String semiMajorAxis;

    @CsvBindByPosition(position = 2)
    private String orbitalPeriod;

    @CsvBindByPosition(position = 3)
    private String rotationPeriod;

    public String getName() {
        return name;
    }

    public Double getSemiMajorAxis() {
        return Double.parseDouble(semiMajorAxis);
    }

    public Double getOrbitalPeriod() {
        return Double.parseDouble(orbitalPeriod);
    }

    public Double getRotationPeriod() {
        return Double.parseDouble(rotationPeriod);
    }
}
