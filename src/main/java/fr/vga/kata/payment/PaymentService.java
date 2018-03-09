package fr.vga.kata.payment;

public class PaymentService {

    private PaymentValidator paymentValidator;

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentValidator paymentValidator, PaymentRepository paymentRepository) {
        this.paymentValidator = paymentValidator;
        this.paymentRepository = paymentRepository;
    }

    public void doPayment(Payment payment) {
        if (paymentValidator.isValid(payment)) {
            paymentRepository.create(payment);
        }
    }
}
