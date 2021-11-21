package com.parkinglot.exceptions;

public class ParkingLotIsFullException extends RuntimeException{
    public ParkingLotIsFullException(String message) {
        super(message);
    }
}
