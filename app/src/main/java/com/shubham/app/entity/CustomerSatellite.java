package com.shubham.app.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "customer_satellites")
@Table(name = "customer_satellites")
public class CustomerSatellite {

    /**
     * "id": "DLR-TUBSAT", "country": "Germany", "launch_date": "26-05-1999",
     * "mass": "45", "launcher": "PSLV-C2"
     */
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "country")
    private String country;

    @Column(name = "launch_date")
    private Date launchDate;

    @Column(name = "mass")
    private Double mass;

    @Column(name = "launcher")
    private String launcher;

    @Column(name = "created_at")
    private Date createdAt;

    public CustomerSatellite() {
    }

    public CustomerSatellite(String id, String country, Date launchDate, Double mass, String launcher, Date createdAt) {
        this.id = id;
        this.country = country;
        this.launchDate = launchDate;
        this.mass = mass;
        this.launcher = launcher;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
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
        return "CustomerSatellite{" + "id='" + id + '\'' + ", country='" + country + '\'' + ", launchDate=" + launchDate
                + ", mass=" + mass + ", launcher='" + launcher + '\'' + ", createdAt=" + createdAt + '}';
    }
}
