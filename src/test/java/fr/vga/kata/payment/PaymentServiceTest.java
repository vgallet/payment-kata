package fr.vga.kata.payment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentValidator paymentValidator;

    private Payment payment;

    @Before
    public void setUp() throws Exception {
        payment = new Payment();

        paymentService = new PaymentService(paymentValidator, paymentRepository);
    }

    @Test
    public void should_create_payment_when_is_valid() {
        // GIVEN
        when(paymentValidator.isValid(payment)).thenReturn(true);

        // WHEN
        paymentService.doPayment(payment);

        // THEN
        verify(paymentRepository, times(1)).create(payment);
    }

    @Test
    public void should_not_create_payment_when_is_invalid() {
        // GIVEN
        when(paymentValidator.isValid(payment)).thenReturn(true);

        // WHEN
        paymentService.doPayment(payment);

        // THEN
        verify(paymentRepository, times(1)).create(payment);
    }
}