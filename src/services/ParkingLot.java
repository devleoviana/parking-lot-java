package services;
import entities.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot{

    Map<String, Vehicle> vehicles = new HashMap<>();

    public void registerEntry(String plate, String model, String color) {
        if (vehicles.containsKey(plate)) {
            System.out.println("Vehicle already registered try another plate");
            return;
        }

        Vehicle vehicle = new Vehicle(plate, model, color, LocalDateTime.now());
        vehicles.put(plate, vehicle);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Vehicle registered: " + plate + " at " + vehicle.getDateTime().format(formatter));
    }

    public void registerExit(String plate){
        Vehicle vehicle = vehicles.get(plate);
        if(vehicle == null){
            System.out.println("Vehicle NOT registered");
            return;
        }

        LocalDateTime exitTime = LocalDateTime.now();
        Duration duration = Duration.between(vehicle.getDateTime(), exitTime);

        long minutes = duration.toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);

        double pricePerHour = 5.0;
        double totalPrice = hours * pricePerHour;

        vehicles.remove(plate);

        System.out.println("Vehicle: " + plate + " exit from parking...");
        System.out.println("Parking time: " + hours + " hours");
        System.out.println("Total price: " + totalPrice);
    }

    public void listVehicles(){
        if(vehicles.isEmpty()){
            System.out.println("No vehicles registered");
            return;
        }

        System.out.println("Vehicles listed");
        for (Vehicle v: vehicles.values()){
            System.out.println(v);
        }
    }
}
