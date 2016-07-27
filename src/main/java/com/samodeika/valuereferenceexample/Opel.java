package com.samodeika.valuereferenceexample;

public class Opel implements Car {

    private String type;
    private String fuelType;
    private int fuelAmount;

    public Opel() {
        this.type = "Opel";
        this.fuelType = "gasoline";
        this.fuelAmount = 0;
    }

    public Opel(String fuelType, int fuelAmount) {
        this.type = "Opel";
        this.fuelType = fuelType;
        this.fuelAmount = fuelAmount;
    }

    @Override
    public void drive() {
        fuelAmount--;
        System.out.println("I`m driving " + type + " and current fuel amount is " + fuelAmount);
    }

    @Override
    public void fuel(int amount) {
        fuelAmount += amount;
        System.out.println("Current Fuel amount is " + fuelAmount);
    }

    @Override
    public String toString() {
        return "Opel{" +
                "type='" + type + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", fuelAmount=" + fuelAmount +
                '}';
    }
}
