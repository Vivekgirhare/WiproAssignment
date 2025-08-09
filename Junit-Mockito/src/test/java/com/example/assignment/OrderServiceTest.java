package com.example.assignment;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
public class OrderServiceTest {

    @Test
    public void testProcessPaymentCalledOnce() {
        PaymentService mockPayment = mock(PaymentService.class);

        OrderService orderService = new OrderService(mockPayment);

        orderService.placeOrder();

        verify(mockPayment, times(1)).processPayment();
    }
}
