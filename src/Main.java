// src/Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();
        Scanner scanner = new Scanner(System.in);

        // Add sample vehicles
        rentalService.addVehicle(new Car("CAR001", "Toyota", "Camry", 50));
        rentalService.addVehicle(new Truck("TRK001", "Ford", "F-150", 80, 1000));
        rentalService.addVehicle(new Motorbike("BIKE001", "Yamaha", "YZF", 30));

        // Menu loop
        while (true) {
            System.out.println("Vehicle Rental System");
            System.out.println("1. Register New Customer");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Display All Transactions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    String customerID = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer newCustomer = new Customer(customerID, name);
                    rentalService.addCustomer(newCustomer);
                    break;

                case 2:
                    System.out.print("Enter customer ID: ");
                    String custID = scanner.nextLine();
                    System.out.print("Enter vehicle ID: ");
                    String vehicleID = scanner.nextLine();
                    System.out.print("Enter number of rental days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Payment paymentMethod = new CreditCardPayment(); // Default to credit card
                    rentalService.rentVehicle(vehicleID, custID, days, paymentMethod);
                    break;

                case 3:
                    rentalService.displayAllTransactions();
                    break;

                case 4:
                    System.out.println("Exiting Vehicle Rental System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
