package com.parkinglot;

import java.util.List;

public class ParkingLotWithFirstAvailableSpace implements ParkingLotSelector{
    @Override
    public ParkingLot selectLot(List<ParkingLot> parkingLots) {
        for(ParkingLot parkingLot : parkingLots){
            if(! parkingLot.isParkingFull() ) {
                //parkingLot.parkCar(car);
                return parkingLot;
            }

        }
        return null;
    }
}
