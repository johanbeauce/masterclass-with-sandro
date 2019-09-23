package be.beauce.training.masterclasswithsandro.paymentservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import be.beauce.training.masterclasswithsandro.paymentservice.FraudService;
import be.beauce.training.masterclasswithsandro.paymentservice.FraudulentException;
import be.beauce.training.masterclasswithsandro.paymentservice.GatewayPayment;
import be.beauce.training.masterclasswithsandro.paymentservice.PaymentDetails;
import be.beauce.training.masterclasswithsandro.paymentservice.PaymentService;
import be.beauce.training.masterclasswithsandro.paymentservice.User;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceShould {

    @Mock
    FraudService fraudService;

    @Mock
    GatewayPayment gatewayPayment;

    @InjectMocks
    PaymentService paymentService;

    User user;
    PaymentDetails paymentDetails;

    @BeforeEach
    void setUp() {
        user = new User();
        paymentDetails = new PaymentDetails();
    }

    @Test
    void throw_an_exception_if_payment_is_fraudulent() {
        given(fraudService.isFraudulent(user, paymentDetails))
                .willReturn(true);

        assertThrows(FraudulentException.class, () -> {
            paymentService.processPayment(user, paymentDetails);
        });
    }

    @Test
    void not_process_payment_if_payment_is_fraudulent() {
        given(fraudService.isFraudulent(user, paymentDetails))
                .willReturn(true);

//        InOrder inOrder = Mockito.inOrder(fraudService, paymentService);

        assertThrows(FraudulentException.class, () -> {
            paymentService.processPayment(user, paymentDetails);
        });
        verifyZeroInteractions(gatewayPayment);
    }

    @Test
    void sent_payment_to_gateway_when_payment_is_legit() {
        given(fraudService.isFraudulent(user, paymentDetails))
                .willReturn(false);

        paymentService.processPayment(user, paymentDetails);

        verify(gatewayPayment).process(paymentDetails);
    }
}
