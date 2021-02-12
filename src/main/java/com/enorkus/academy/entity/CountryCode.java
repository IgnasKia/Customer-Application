package com.enorkus.academy.entity;

public enum CountryCode {
    LT("LT"),
    LV("LV"),
    EE("EE"),
    SE("SE");

    private String value;

    CountryCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}