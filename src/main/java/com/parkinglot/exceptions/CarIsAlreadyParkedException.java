package com.parkinglot.exceptions;

public class CarIsAlreadyParkedException extends RuntimeException {
    public CarIsAlreadyParkedException(String message) {
        super(message);
    }
}
