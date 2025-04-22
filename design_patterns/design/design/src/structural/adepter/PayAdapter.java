package structural.adepter;

public class PayAdapter implements Payment {
    private final PaySDK paySDK;

    public PayAdapter(PaySDK paySDK) {
        this.paySDK = paySDK;
    }

    @Override
    public void pay() {
        // something...
        paySDK.sendPay();
    }
}
