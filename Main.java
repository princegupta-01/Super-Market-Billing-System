import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ProductManager productManager = new ProductManager();
    private static BillingService billingService = new BillingService();
    private static ReceiptPrinter receiptPrinter = new ReceiptPrinter();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== SUPERMARKET BILLING SYSTEM ===");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Search Product");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    productManager.viewProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    productManager.searchProduct(sc.nextLine().trim());
                    break;
                case 4:
                    generateBill();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Product name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Price: ");
        double price = readDouble();
        System.out.print("Stock quantity: ");
        int stock = readInt();

        if (price < 0 || stock < 0) {
            System.out.println("Price and stock cannot be negative.");
            return;
        }

        productManager.addProduct(name, price, stock);
        System.out.println("Product added.");
    }

    private static void generateBill() {
        CartManager cart = new CartManager();

        while (true) {
            productManager.viewProducts();
            System.out.print("\nEnter product ID (0 to finish): ");
            int id = readInt();
            if (id == 0) break;

            Product product = productManager.findById(id);
            if (product == null) {
                System.out.println("Invalid product ID.");
                continue;
            }

            System.out.print("Quantity: ");
            int quantity = readInt();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                continue;
            }
            if (quantity > product.getStock()) {
                System.out.println("Not enough stock.");
                continue;
            }

            cart.addItem(product, quantity);
            product.setStock(product.getStock() - quantity);
            System.out.println("Added to bill.");
        }

        if (cart.isEmpty()) {
            System.out.println("No items added.");
            return;
        }

        double subtotal = cart.getSubtotal();
        double discount = billingService.getDiscount(subtotal);
        double tax = billingService.getTax(subtotal, discount);
        double total = billingService.getTotal(subtotal, discount, tax);

        receiptPrinter.printReceipt(cart.getItems(), subtotal, discount, tax, total);
        System.out.println("Bill generated. Stock updated.");
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
