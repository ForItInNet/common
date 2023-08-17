package com.foryouinnet.common.model.enumeration;

public enum CustomHeaderEnum {
    CLIENT_IDENTIFIER("Client-Identifier");

    private String name;

    CustomHeaderEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
