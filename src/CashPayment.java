// src/CashPayment.java
public class CashPayment implements Payment {
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }
}

