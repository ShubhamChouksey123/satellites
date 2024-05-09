package com.shubham.app.dto;

import com.shubham.app.model.LaunchType;

public class LauncherDto {

    private Long dbId;
    private String id;
    private LaunchType launchType;
    private String registeredOn;

    public LauncherDto() {
    }

    public LauncherDto(Long dbId, String id, LaunchType launchType, String registeredOn) {
        this.dbId = dbId;
        this.id = id;
        this.launchType = launchType;
        this.registeredOn = registeredOn;
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

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    @Override
    public String toString() {
        return "LauncherDto{" + "dbId=" + dbId + ", id='" + id + '\'' + ", launchType=" + launchType
                + ", registeredOn='" + registeredOn + '\'' + '}';
    }
}
