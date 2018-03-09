package fr.vga.kata.payment;

public class PaymentRepository {

    public void create(Payment payment) {
        throw new IllegalStateException("PaymentRepository should not be invoked on an unit test.");
    }
}
