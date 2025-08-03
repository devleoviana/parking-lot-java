package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vehicle {
    private String plate;
    private String model;
    private String color;
    private LocalDateTime dateTime;

    public Vehicle(String plate, String model, String color, LocalDateTime dateTime) {
        this.plate = plate;
        this.model = model;
        this.color = color;
        this.dateTime = dateTime;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Model: " + model +
                ", Plate: " + plate +
                ", Color: " + color +
                ", Entry: " + dateTime.format(dtf);
    }

}
