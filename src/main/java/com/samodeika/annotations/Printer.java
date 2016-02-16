package com.samodeika.annotations;

@PrintingDevice(defaultPrintMethod = "print", defaultNumberOfCopies = 5)
public class Printer {

    private String text;
    private int copies;

    public Printer(String text, int copies) {
        this.text = text;
        this.copies = copies;
    }

    public Printer() {
    }

    @Deprecated
    public void print(String text) {
        System.out.println("Printing " + text);
    }

    public void print() {
        for (int i = 0; i < this.copies; i++) {
            System.out.println("Printing copy " + this.copies + " " + this.text);
        }
    }

    public void print(int copies) {
        for (int i = 0; i < copies; i++) {
            System.out.println("Printing copy " + copies + " " + this.text);
        }
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
