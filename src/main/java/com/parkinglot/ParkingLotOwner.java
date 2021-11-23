package com.parkinglot;

public class ParkingLotOwner implements ParkingLotObserver {
    String message;

    @Override
    public void update(String message) {

        this.message=message;
    }
}
