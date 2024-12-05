
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
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer newCustomer = new Customer(name);
                    rentalService.addCustomer(newCustomer);

                    // Display the registration confirmation with a banner
                    System.out.println("\n==============================");
                    System.out.println("  🎉 New Customer Registered! 🎉");
                    System.out.println("==============================");
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Customer ID: " + newCustomer.getCustomerID());
                    System.out.println("==============================\n");
                    break;

                
                case 2:
                System.out.println("\n==============================");
                System.out.println("🚗 Rent a Vehicle");
                System.out.println("==============================");
            
                System.out.print("Enter customer ID: ");
                String custID = scanner.nextLine();
            
                // Display available vehicles
                System.out.println("\nAvailable Vehicles:");
                System.out.println("==============================");
                rentalService.displayAvailableVehicles(); // Method to display all registered vehicles
                System.out.println("==============================");
            
                System.out.print("Enter vehicle ID: ");
                String vehicleID = scanner.nextLine();
                System.out.print("Enter number of rental days: ");
                int days = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            
                Payment paymentMethod = new CreditCardPayment(); // Default to credit card
                rentalService.rentVehicle(vehicleID, custID, days, paymentMethod);
            
                System.out.println("\n==============================");
                System.out.println("✅ Vehicle Rental Process Completed!");
                System.out.println("==============================\n");
                break;
            

                case 3:
                    System.out.println("\n==============================");
                    System.out.println("📜 Displaying All Transactions");
                    System.out.println("==============================");
                    rentalService.displayAllTransactions();
                    System.out.println("\n==============================");
                    System.out.println("✅ End of Transactions List");
                    System.out.println("==============================\n");
                    break;

                case 4:
                    System.out.println("\n==============================");
                    System.out.println("👋 Exiting Vehicle Rental System");
                    System.out.println("==============================");
                    System.out.println("Thank you for using our service. Goodbye!");
                    System.out.println("==============================\n");
                    scanner.close();
                    return;

                default:
                    System.out.println("\n==============================");
                    System.out.println("⚠️ Invalid Option");
                    System.out.println("==============================");
                    System.out.println("Please try again with a valid choice.");
                    System.out.println("==============================\n");
                    break;

            }
        }
    }
}
