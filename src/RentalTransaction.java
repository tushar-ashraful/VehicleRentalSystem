// src/RentalTransaction.java
public class RentalTransaction {
    private String transactionID;
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;
    private double rentalFee;

    public RentalTransaction(String transactionID, Customer customer, Vehicle vehicle, int rentalDays) {
        this.transactionID = transactionID;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.rentalFee = vehicle.calculateRentalFee(rentalDays);
    }

    public double getRentalFee() { return rentalFee; }

    public void printInvoice() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Vehicle ID: " + vehicle.getVehicleID());
        System.out.println("Rental Fee: $" + rentalFee);
        System.out.println("------------------------------");
    }
}
