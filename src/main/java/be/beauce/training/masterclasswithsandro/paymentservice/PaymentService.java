package be.beauce.training.masterclasswithsandro.paymentservice;

public class PaymentService {

    FraudService fraudService;
    GatewayPayment gatewayPayment;

    public PaymentService(FraudService fraudService, GatewayPayment gatewayPayment) {
        this.fraudService = fraudService;
        this.gatewayPayment = gatewayPayment;
    }

    public void processPayment(User user, PaymentDetails paymentDetails) {
        if (fraudService.isFraudulent(user, paymentDetails)) {
            throw new FraudulentException();
        }
        gatewayPayment.process(paymentDetails);
    }
}
