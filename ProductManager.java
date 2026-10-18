import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();
    private int nextId = 1;

    public ProductManager() {
        addProduct("Rice 1kg", 65.00, 20);
        addProduct("Milk 1L", 60.00, 15);
        addProduct("Soap", 35.00, 25);
        addProduct("Biscuits", 20.00, 30);
    }

    public void addProduct(String name, double price, int stock) {
        products.add(new Product(nextId++, name, price, stock));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void viewProducts() {
        System.out.println("\nID  Product          Price     Stock");
        System.out.println("-------------------------------------");
        for (Product p : products) {
            System.out.printf("%-3d %-16s Rs.%-7.2f %d%n",
                    p.getId(), p.getName(), p.getPrice(), p.getStock());
        }
    }

    public void searchProduct(String keyword) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.printf("ID: %d | %s | Rs. %.2f | Stock: %d%n",
                        p.getId(), p.getName(), p.getPrice(), p.getStock());
                found = true;
            }
        }
        if (!found) System.out.println("Product not found.");
    }
}
