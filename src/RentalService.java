
// src/RentalService.java
import java.util.ArrayList;

public class RentalService {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<RentalTransaction> transactions = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        // System.out.println("Customer added: " + customer.getName());
    }

    public Customer findCustomer(String customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }

    public void rentVehicle(String vehicleID, String customerID, int days, Payment payment) {
        Customer customer = findCustomer(customerID);
        Vehicle vehicle = findVehicle(vehicleID);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        if (vehicle != null && vehicle.isAvailable()) {
            vehicle.rent();
            RentalTransaction transaction = new RentalTransaction("TXN" + System.currentTimeMillis(), customer, vehicle,
                    days);
            transactions.add(transaction);
            transaction.printInvoice();
            payment.processPayment(transaction.getRentalFee());
            vehicle.returnVehicle();
        } else {
            System.out.println("Vehicle is not available!");
        }
    }

    /// todo:need
    public void displayAvailableVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles are currently registered.");
            return;
        }
        boolean anyAvailable = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println("Vehicle ID: " + vehicle.getVehicleID() +
                        ", Brand: " + vehicle.getMake() +
                        ", Model: " + vehicle.getModel() +
                        ", Daily Rent: $" + vehicle.getDailyRent());
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No vehicles are currently available for rent.");
        }

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles are currently registered.");
            return;
        }
        anyAvailable = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println("Vehicle ID: " + vehicle.getVehicleID() +
                        ", Brand: " + vehicle.getMake() +
                        ", Model: " + vehicle.getModel() +
                        ", Daily Rent: $" + vehicle.getDailyRent());
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No vehicles are currently available for rent.");
        }
    }

    private Vehicle findVehicle(String vehicleID) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleID().equals(vehicleID)) {
                return vehicle;
            }
        }
        return null;
    }

    public void displayAllTransactions() {
        for (RentalTransaction transaction : transactions) {
            transaction.printInvoice();
        }
    }
}
