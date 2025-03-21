package fr.EcommerceApp.order.payment;

abstract class PaymentMethod {
    public abstract void processPayment(double amount);
}