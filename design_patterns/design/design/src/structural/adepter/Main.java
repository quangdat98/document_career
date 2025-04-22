package structural.adepter;

public class Main {
    public static void main(String[] args) {
        PaySDK paySDK = new PaySDK();
        Payment payment = new PayAdapter(paySDK);

        payment.pay();
    }
}
