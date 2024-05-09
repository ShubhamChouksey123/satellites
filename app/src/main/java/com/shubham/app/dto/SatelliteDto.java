package com.shubham.app.dto;

import java.util.Date;

public class SatelliteDto {

    private String satelliteId;
    private String country;
    private String launchDate;
    private Double mass;
    private String launcher;
    private Date createdAt;

    public SatelliteDto() {
    }

    public SatelliteDto(String satelliteId, String country, String launchDate, Double mass, String launcher,
            Date createdAt) {
        this.satelliteId = satelliteId;
        this.country = country;
        this.launchDate = launchDate;
        this.mass = mass;
        this.launcher = launcher;
        this.createdAt = createdAt;
    }

    public String getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(String satelliteId) {
        this.satelliteId = satelliteId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getLauncher() {
        return launcher;
    }

    public void setLauncher(String launcher) {
        this.launcher = launcher;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SatelliteDto{" + "satelliteId='" + satelliteId + '\'' + ", country='" + country + '\'' + ", launchDate="
                + launchDate + ", mass=" + mass + ", launcher='" + launcher + '\'' + ", createdAt=" + createdAt + '}';
    }
}
