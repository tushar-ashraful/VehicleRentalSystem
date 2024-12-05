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

    // Getter for Vehicle ID
    public String getVehicleID() { 
        return vehicleID; 
    }

    // Getter for Make
    public String getMake() { 
        return make; 
    }

    // Getter for Model
    public String getModel() { 
        return model; 
    }

    // Getter for Rental Rate
    public double getDailyRent() { 
        return rentalRate; 
    }

    // Check Availability
    public boolean isAvailable() { 
        return available; 
    }

    // Mark as Rented
    public void rent() { 
        available = false; 
    }

    // Mark as Returned
    public void returnVehicle() { 
        available = true; 
    }

    // Calculate Rental Fee
    public double calculateRentalFee(int days) {
        return days * rentalRate;
    }
}
