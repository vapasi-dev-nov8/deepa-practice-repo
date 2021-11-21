package com.parkinglot;

public class ParkingLotOwner implements Observer {
    String message;

    @Override
    public void update(String message) {
        this.message=message;
    }
}
