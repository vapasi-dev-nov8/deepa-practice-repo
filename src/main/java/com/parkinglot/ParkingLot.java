package com.parkinglot;

import com.parkinglot.exceptions.CarIsAlreadyParkedException;
import com.parkinglot.exceptions.ParkingLotIsFullException;
import com.parkinglot.exceptions.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    int capacity;



    public ParkingLot(int capacity) {
        this.capacity=capacity;
    }

    List<Car> parkingLot = new ArrayList<>(capacity);

    List<Observer> observerList= new ArrayList<>();

    public void parkCar(Car car) {
        if(isParkingFull()) {
            notifyObservers("Parking Lot Is Full");
            throw new ParkingLotIsFullException("Parking Lot Is Full");
        }
        if(isTheCarInTheParkingLot(car))
            throw new CarIsAlreadyParkedException("Car is parked already");
        parkingLot.add(car);
        if(isParkingFull())
            notifyObservers("Parking Lot Is Full");
    }

    public boolean isParkingFull() {
        return (parkingLot.size() == capacity);
    }

    public boolean isTheCarInTheParkingLot(Car car) {
        return parkingLot.contains(car);
    }

    public void removeCar(Car car) {
        if (!isTheCarInTheParkingLot(car))
            throw new VehicleNotFoundException("Car is not in the Parking Lot");
        parkingLot.remove(car);
        if(!isParkingFull())
            notifyObservers("Parking Lot Has Available Space");
    }

    public void notifyObservers(String message){
        for (Observer observers : observerList) {
            observers.update(message);
        }
    }
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

}
