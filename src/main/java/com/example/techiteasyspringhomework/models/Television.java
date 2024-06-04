package com.example.techiteasyspringhomework.models;

public class Television extends Product {

    private String type;
    private double available;
    private double refreshRate;
    private String screenTypes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenTypes() {
        return screenTypes;
    }

    public void setScreenTypes(String screenTypes) {
        this.screenTypes = screenTypes;
    }
}
