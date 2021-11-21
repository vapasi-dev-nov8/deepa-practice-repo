package com.parkinglot.test;


import com.parkinglot.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import com.parkinglot.exceptions.CarIsAlreadyParkedException;
import com.parkinglot.exceptions.VehicleNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ParkingLotTest {

    @Nested
    class ParkCar{

        @Test
        void shouldParkTheCarInTheParkingLot(){
            ParkingLot parkingLot=new ParkingLot(2);
            Car car=new Car();
            assertDoesNotThrow(
                    () -> parkingLot.parkCar(car)
            );
        }

        @Test
        void shouldNotParkTheSameCarInParkingLotTwice(){
            ParkingLot parkingLot=new ParkingLot(2);
            Car car=new Car();
            parkingLot.parkCar(car);
            assertThrows(CarIsAlreadyParkedException.class,
                    () -> parkingLot.parkCar(car)
            );


        }

        @Test
        void carIsNotParkedInTheLot(){
            ParkingLot parkingLot=new ParkingLot(2);
            Car car=new Car();
            Car car1=new Car();
            parkingLot.parkCar(car);

            assertFalse(parkingLot.isTheCarInTheParkingLot(car1));
        }


    }

    @Nested
    class UnPark{
        @Test
        void getTheCarFromTheParkingLot(){
            ParkingLot parkingLot=new ParkingLot(1);
            Car car=new Car();
            parkingLot.parkCar(car);
            assertDoesNotThrow(
                    () -> parkingLot.removeCar(car)
            );

        }

        @Test
        void shouldThrowVehicleNotFoundException(){
            ParkingLot parkingLot=new ParkingLot(1);
            Car car=new Car();
            Car car1=new Car();
            parkingLot.parkCar(car);
            assertThrows(VehicleNotFoundException.class,
                    () -> parkingLot.removeCar(car1)
            );

        }

    }

    @Nested
    class Observers{

        @Test
        void shouldNotifyObserversWhenParkingSpaceIsAvailable() {
            // Given
            Observer parkingLotOwner = mock(ParkingLotOwner.class);
            Observer trafficCop = mock(TrafficCop.class);
            ParkingLot parkingLot = new ParkingLot(1);
            parkingLot.registerObserver(parkingLotOwner);
            parkingLot.registerObserver(trafficCop);
            // When
            Car car1 = new Car();
            parkingLot.parkCar(car1);
            parkingLot.removeCar(car1);

            // Expect
            verify(parkingLotOwner, times(1)).update("Parking Lot Has Available Space");
            verify(trafficCop, times(1)).update("Parking Lot Has Available Space");
        }

        @Test
        void shouldNotifyObserversWhenParkingLotIsFull() {
            Observer parkingLotOwner = mock(ParkingLotOwner.class);
            Observer trafficCop = mock(TrafficCop.class);
            ParkingLot parkingLot = new ParkingLot(1);
            parkingLot.registerObserver(parkingLotOwner);
            parkingLot.registerObserver(trafficCop);
            // When
            Car car1 = new Car();
            parkingLot.parkCar(car1);

            // Expect
            verify(parkingLotOwner, times(1)).update("Parking Lot Is Full");
            verify(trafficCop, times(1)).update("Parking Lot Is Full");
        }

    }




}
