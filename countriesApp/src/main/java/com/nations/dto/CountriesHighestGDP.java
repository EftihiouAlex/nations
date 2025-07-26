package com.nations.dto;

import java.math.BigDecimal;

public class CountriesHighestGDP {
    private long id;
    private String countryName;
    private String countryCode3;
    private int year;
    private long population;
    private BigDecimal gdp;

    public CountriesHighestGDP( long id, String countryName, String countryCode3, int year, long population, BigDecimal gdp) {
        this.id = id;
        this.countryName = countryName;
        this.countryCode3 = countryCode3;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }
}
