// src/Vehicle.java
public abstract class Vehicle {
    private String vehicleID;
    private String make;
    private String model;
    private double rentalRate;
    private boolean available = true;

    public Vehicle(String vehicleID, String make, String model, double rentalRate) {
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.rentalRate = rentalRate;
    }

    public String getVehicleID() { return vehicleID; }
    public boolean isAvailable() { return available; }
    public void rent() { available = false; }
    public void returnVehicle() { available = true; }

    public double calculateRentalFee(int days) {
        return days * rentalRate;
    }
}
