package com.parkinglot;

public class TrafficCop implements Observer{
    String message;
    @Override
    public void update(String message) {
        this.message=message;
    }
}
