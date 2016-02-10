package com.samodeika.annotations;

public class Printer {

    private String text;

    public Printer(String text) {
        this.text = text;
    }

    public Printer() {
    }

    @Deprecated
    public void print(String text) {
        System.out.println("Printing " + text);
    }

    public void print() {
        System.out.println("Printing " + this.text);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "text='" + text + '\'' +
                '}';
    }

    @SuppressWarnings("unused")
    private void checkPrint() {
        String isEmpty = (text.isEmpty()) ? "empty" : "not empty";
        System.out.println("Text fild is " + isEmpty);
    }
}
