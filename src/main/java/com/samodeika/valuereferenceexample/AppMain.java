package com.samodeika.valuereferenceexample;

public class AppMain {

    public static void main(String[] args) {
        Car car1 = new Opel();
        car1.fuel(50);
        car1.drive();

        Car car2 = new Opel("diesel", 150);

        int num = 1;

        System.out.println("Number is " + num);
        System.out.println(car1);
        System.out.println(car2);
        System.out.println("--------------------------");

        changeValue(num, car1, car2);

        System.out.println("Number is " + num);
        System.out.println(car1);
        System.out.println(car2);
    }

    private static void changeValue(int num, Car... cars) {
        num = 100;

        int count = 0;
        for (Car car : cars) {
            if (count == 0) {
                car = new Opel("diesel", 20);
            }
            if (count == 1) {
                car.fuel(20);
                car.drive();
            }
            count++;
        }
    }
}
