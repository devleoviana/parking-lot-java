package services;
import entities.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot{

    Map<String, Vehicle> vehicles = new HashMap<>();

    public void registerEntry(String plate, String model, String color) {
        if(vehicles.containsKey(plate)){
            System.out.println("Vehicle already registered");
            return;
        }

        Vehicle vehicle = new Vehicle(plate, model, color, LocalDateTime.now());
        vehicles.put(plate, vehicle);

        System.out.println("Vehicle registered" + plate + " in "  + vehicle.getDateTime());

    }
}
