package com.shubham.app.model;

public enum LaunchType {
    NEW(0), OLD(1), DEGRADED(2);

    private final int level;

    private LaunchType(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public LaunchType findByValue(int level) {
        for (LaunchType launchType : values()) {
            if (launchType.getLevel() == level) {
                return launchType;
            }
        }
        System.out.println("Enum Declaration Error ! : Incorrect launchType, Not supported  : " + level);
        return null;
    }
}
