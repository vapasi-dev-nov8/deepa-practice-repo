package com.parkinglot;

public class TrafficCop implements ParkingLotObserver {
    String message;
    @Override
    public void update(String message) {
        this.message=message;
    }
}
