package com.samodeika.luxoft;

public enum Day {

    Monday("Mon"),
    Tuesday("Tue"),
    Wednesday("Wed"),
    Thursday("Thu"),
    Friday("Fri"),
    Saturday("Sat"),
    Sunday("Sun"),
    ;

    private final String dbMapping;

    Day(String dbMapping) {
        this.dbMapping = dbMapping;
    }

    public String getDbMapping() {
        return dbMapping;
    }

    public static Day convertFromDbMapping(String dbMapping) {
        for (Day day: values()) {
            if (day.getDbMapping().equalsIgnoreCase(dbMapping))
                return day;
        }

        return null;
    }
}
