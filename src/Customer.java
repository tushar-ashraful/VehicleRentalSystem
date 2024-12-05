// src/Customer.java
public class Customer {
    private static int idCounter = 1; // Static counter for generating unique IDs
    private String customerID;
    private String name;

    public Customer(String name) {
        this.customerID = "CUST00" + idCounter; // Generate ID with a prefix
        idCounter++; // Increment the counter
        this.name = name;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }
}


