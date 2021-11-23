package com.parkinglot.test;

import com.parkinglot.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ParkingLotWithMaxFreeSpaceTest {

    @Test
    public void parkTheCarInTheParkingLotWithMaxFreeSpace() {
        // given
        Attendant attendant=new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(4);
        ParkingLot parkingLot2 = new ParkingLot(3);
        attendant.manage(parkingLot1);
        attendant.manage(parkingLot2);
        ParkingLotSelector parkingLotSelector=new ParkingLotWithMaxFreeSpace();

        //When
        Car car = new Car();
        parkingLot2.parkCar(car);

        //Expected
        assertEquals(parkingLot1, parkingLotSelector.selectLot(attendant.parkingLots));

        //When
        Car car1 = new Car();
        parkingLot2.parkCar(car1);

        //Expected
        assertEquals(parkingLot1, parkingLotSelector.selectLot(attendant.parkingLots));
    }
}
