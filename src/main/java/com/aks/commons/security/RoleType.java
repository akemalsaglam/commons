package com.aks.commons.security;

public enum RoleType {

    ADMIN("ADMIN"),
    USER("USER");


    public final String value;

    RoleType(String value) {
        this.value = value;
    }
}
