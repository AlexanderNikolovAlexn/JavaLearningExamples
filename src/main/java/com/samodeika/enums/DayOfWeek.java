package com.samodeika.enums;

public enum DayOfWeek {

    MON("Monday"), TUE("Tuesday"), WED("Wednesday"), THU("Thursday"), FRI("Friday"), SAT("Saturday"), SUN("Sunday");
    private String value;

    DayOfWeek(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
