package com.foodies.backend.data;

public enum FlavourType {
    SWEET("sweet"),
    SAVOURY("savoury");

    private final String type;

    FlavourType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
