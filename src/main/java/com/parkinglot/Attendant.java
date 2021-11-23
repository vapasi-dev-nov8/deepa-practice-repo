package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Attendant implements ParkingLotObserver {

    public List<ParkingLot> parkingLots=new ArrayList<>();
    private ParkingLotSelector parkingLotSelector=new ParkingLotWithMaxFreeSpace();

    @Override
    public void update(String message) {

    }

    public void manage(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
    }

    public void park(Car car) {
        ParkingLot parkingLot=parkingLotSelector.selectLot(parkingLots);
        parkingLot.parkCar(car);

    }

    public void parkingLotSelectorToUse(ParkingLotSelector parkingLotSelector) {
        this.parkingLotSelector=parkingLotSelector;

    }
}
