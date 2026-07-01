import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int id;
    String name;
    String type;

    public Product(int i, String n, String t) {
        id = i;
        name = n;
        type = t;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Category: " + type;
    }
}

public class ProductSearch {

    public static Product linearSearch(Product[] arr, int key) {
        for (Product p : arr) {
            if (p.id == key) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m].id == key) {
                return arr[m];
            }

            if (arr[m].id < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = in.nextInt();
        in.nextLine();

        Product[] arr = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product ID for product " + (i + 1) + ": ");
            int id = in.nextInt();
            in.nextLine();

            System.out.print("Enter product name for product " + (i + 1) + ": ");
            String name = in.nextLine();

            System.out.print("Enter category for product " + (i + 1) + ": ");
            String type = in.nextLine();

            arr[i] = new Product(id, name, type);
        }

        Arrays.sort(arr, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                if (a.id < b.id)
                    return -1;
                else if (a.id > b.id)
                    return 1;
                else
                    return 0;
            }
        });

        System.out.print("Enter the product ID to search: ");
        int key = in.nextInt();

        Product x = linearSearch(arr, key);
        if (x != null)
            System.out.println("Product found using Linear Search: " + x);
        else
            System.out.println("Product not found using Linear Search.");

        x = binarySearch(arr, key);
        if (x != null)
            System.out.println("Product found using Binary Search: " + x);
        else
            System.out.println("Product not found using Binary Search.");
        in.close();
    }
}