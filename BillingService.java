public class BillingService {
    private static final double DISCOUNT_RATE = 0.05;
    private static final double DEMO_TAX_RATE = 0.05;

    public double getDiscount(double subtotal) {
        return subtotal >= 1000 ? subtotal * DISCOUNT_RATE : 0;
    }

    public double getTax(double subtotal, double discount) {
        return (subtotal - discount) * DEMO_TAX_RATE;
    }

    public double getTotal(double subtotal, double discount, double tax) {
        return subtotal - discount + tax;
    }
}
