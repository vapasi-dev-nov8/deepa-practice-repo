package com.parkinglot.test;

import com.parkinglot.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AttendantTest {

    @Test
    void attendantShouldBeAbleToParkTheCar(){
        Attendant attendant = new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);

        attendant.manage(parkingLot1);
        attendant.manage(parkingLot2);

        //When
        Car car1 = new Car();

        //Expected
        assertDoesNotThrow(
                () -> attendant.park(car1)
        );

        Car car2 = new Car();
        assertDoesNotThrow(
                () -> attendant.park(car2)
        );

    }

    @Test
    void attendantShouldParkTheCarAsPerMaxAvailableFreeSpace(){
        Attendant attendant = new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(4);
        attendant.manage(parkingLot1);
        attendant.manage(parkingLot2);

        ParkingLotSelector parkingLotSelector = mock(ParkingLotSelector.class);
        when(parkingLotSelector.selectLot(any())).thenReturn(parkingLot1);

        attendant.parkingLotSelectorToUse(parkingLotSelector);

        //When
        Car car = new Car();
        attendant.park(car);

        //Expected
        assertEquals(true, parkingLot1.isTheCarInTheParkingLot(car));
    }
}
