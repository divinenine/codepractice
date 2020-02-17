package com.hyperskills.enums;

import java.util.ArrayList;
import java.util.List;

public enum ChargeLevel {
    FULL(4, "green"),
    HIGH(3, "green"),
    MEDIUM(2, "yellow"),
    LOW(1, "red");

    private final int sections;

    private final String color;

    ChargeLevel(int sections, String color) {
        this.sections = sections;
        this.color = color;
    }
    public int getSections() {
        return sections;
    }

    public String getColor() {
        return color;
    }

    public static List<ChargeLevel> findByColor(String color) {
        List<ChargeLevel> values = new ArrayList<>();
        for (ChargeLevel value : values()) {

            if (color.equals(value.color)) {
                values.add(value);
            }

        }

        return values;



    }
}
