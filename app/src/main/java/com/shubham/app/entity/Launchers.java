package com.shubham.app.entity;

import com.shubham.app.model.LaunchType;

import java.util.Date;
import jakarta.persistence.*;

@Entity(name = "launchers")
@Table(name = "launchers")
public class Launchers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "db_id")
    private Long dbId;

    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "launch_type")
    @Enumerated(EnumType.STRING)
    private LaunchType launchType;

    @Column(name = "registered_on")
    private Date registeredOn;

    @Column(name = "created_at")
    private Date createdAt;

    public Launchers() {
    }

    public Launchers(String id, LaunchType launchType, Date registeredOn, Date createdAt) {
        this.id = id;
        this.launchType = launchType;
        this.registeredOn = registeredOn;
        this.createdAt = createdAt;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LaunchType getLaunchType() {
        return launchType;
    }

    public void setLaunchType(LaunchType launchType) {
        this.launchType = launchType;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Launchers{" + "dbId=" + dbId + ", id='" + id + '\'' + ", launchType=" + launchType + ", registeredOn="
                + registeredOn + ", createdAt=" + createdAt + '}';
    }
}
