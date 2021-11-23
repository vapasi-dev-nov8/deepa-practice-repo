package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class ParkingLotWithMaxFreeSpace implements ParkingLotSelector{
    @Override
    public ParkingLot selectLot(List<ParkingLot> parkingLots) {
        return parkingLots
                .stream()
                .max(Comparator.comparing(ParkingLot::getAvailableSpace))
                .get();

    }
}
