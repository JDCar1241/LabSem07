package adapter;

public class PayPalAdapter implements PaymentProcessor {

    private ExternalPayPalService payPalService;

    public PayPalAdapter(ExternalPayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public void pay(double amount) {
        payPalService.makePayment("PEN", amount);
    }
}