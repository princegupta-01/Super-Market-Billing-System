import java.util.ArrayList;

public class ReceiptPrinter {
    public void printReceipt(ArrayList<CartItem> items,
                             double subtotal, double discount,
                             double tax, double total) {
        System.out.println("\n============= RECEIPT =============");
        System.out.printf("%-16s %5s %10s%n", "Product", "Qty", "Amount");
        System.out.println("-----------------------------------");
        for (CartItem item : items) {
            System.out.printf("%-16s %5d %10.2f%n",
                    item.getProduct().getName(),
                    item.getQuantity(), item.getLineTotal());
        }
        System.out.println("-----------------------------------");
        System.out.printf("Subtotal:       Rs. %.2f%n", subtotal);
        System.out.printf("Discount:       Rs. %.2f%n", discount);
        System.out.printf("Demo tax (5%%): Rs. %.2f%n", tax);
        System.out.printf("TOTAL:          Rs. %.2f%n", total);
        System.out.println("===================================");
    }
}
