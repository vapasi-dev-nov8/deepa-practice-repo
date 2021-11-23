package com.parkinglot.test;

import com.parkinglot.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotWithFirstAvailableSpaceTest {

    @Test
    public void parkTheCarInTheParkingLotWithFirstAvailableSpace() {
        // given
        Attendant attendant=new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        attendant.manage(parkingLot1);
        attendant.manage(parkingLot2);
        ParkingLotSelector parkingLotSelector=new ParkingLotWithFirstAvailableSpace();

        //When
        Car car = new Car();
        parkingLot1.parkCar(car);
        Car car1 = new Car();
        parkingLot2.parkCar(car1);


        //Expected
        assertEquals(parkingLot1, parkingLotSelector.selectLot(attendant.parkingLots));




    }
}
