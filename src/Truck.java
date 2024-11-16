// src/Truck.java
public class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String vehicleID, String make, String model, double rentalRate, double cargoCapacity) {
        super(vehicleID, make, model, rentalRate);
        this.cargoCapacity = cargoCapacity;
    }
}
