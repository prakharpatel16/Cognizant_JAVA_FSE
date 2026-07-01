import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private List<Product> list;

    public Inventory() {
        list = new ArrayList<>();
    }

    public void addProduct(Product p) {
        list.add(p);
    }

    public void updateProduct(int id, String n, int q, double pr) {
        for (Product x : list) {
            if (x.getProductId() == id) {
                x.setProductName(n);
                x.setQuantity(q);
                x.setPrice(pr);
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product ID not found.");
    }

    public void deleteProduct(int id) {
        Product temp = null;

        for (Product x : list) {
            if (x.getProductId() == id) {
                temp = x;
                break;
            }
        }

        if (temp != null) {
            list.remove(temp);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void displayProducts() {
        if (list.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product x : list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Inventory obj = new Inventory();

        char ch = 'y';

        while (ch == 'y' || ch == 'Y') {
            System.out.println("\nEnter Product Details");

            System.out.print("Product ID: ");
            int id = in.nextInt();
            in.nextLine();

            System.out.print("Product Name: ");
            String name = in.nextLine();

            System.out.print("Quantity: ");
            int qty = in.nextInt();

            System.out.print("Price: ");
            double cost = in.nextDouble();

            obj.addProduct(new Product(id, name, qty, cost));

            System.out.print("Do you want to add another product? (y/n): ");
            ch = in.next().charAt(0);
        }

        System.out.println("\nCurrent Inventory:");
        obj.displayProducts();

        System.out.print("\nEnter Product ID to update: ");
        int up = in.nextInt();

        obj.updateProduct(up, "Gaming Laptop", 5, 95000);

        System.out.println("\nInventory after update:");
        obj.displayProducts();

        System.out.print("\nEnter Product ID to delete: ");
        int del = in.nextInt();

        obj.deleteProduct(del);
        System.out.println("\nInventory after deletion:");
        obj.displayProducts();
        in.close();
    }
}