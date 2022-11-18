package com.aks.commons.jpa;

public enum Status {

    ACTIVE("ACTIVE"),
    PASSIVE("PASSIVE"),
    BLOCK("BLOCK");

    public final String value;

    Status(String value) {
        this.value = value;
    }
}
