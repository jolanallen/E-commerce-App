package fr.EcommerceApp.order.payment;

public class PayPal extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of: $" + amount);
    }
}