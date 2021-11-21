package com.parkinglot;

public class Car {
    private String brandName;
    private String licensePlate;

    public Car() {
    }

    public Car(String brandName, String licensePlate) {
        this.brandName = brandName;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brandName='" + brandName + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
