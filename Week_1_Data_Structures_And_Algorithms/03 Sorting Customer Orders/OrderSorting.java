import java.util.Scanner;

class Order {
    int id;
    String name;
    double price;

    public Order(int i, String n, double p) {
        id = i;
        name = n;
        price = p;
    }

    @Override
    public String toString() {
        return "OrderID: " + id + ", Customer: " + name + ", Total Price: $" + price;
    }
}

public class OrderSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of orders: ");
        int n = in.nextInt();
        in.nextLine();

        Order[] arr = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for order " + (i + 1) + ":");

            System.out.print("Order ID: ");
            int id = in.nextInt();
            in.nextLine();

            System.out.print("Customer Name: ");
            String name = in.nextLine();

            System.out.print("Total Price: ");
            double price = in.nextDouble();
            in.nextLine();

            arr[i] = new Order(id, name, price);
        }

        System.out.println("\nUnsorted Orders:");
        for (Order x : arr) {
            System.out.println(x);
        }

        bubbleSort(arr);

        System.out.println("\nOrders Sorted by Bubble Sort:");
        for (Order x : arr) {
            System.out.println(x);
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nOrders Sorted by Quick Sort:");
        for (Order x : arr) {
            System.out.println(x);
        }

        in.close();
    }

    public static void bubbleSort(Order[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].price > arr[j + 1].price) {
                    Order t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static void swap(Order[] arr, int i, int j) {
        Order t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void quickSort(Order[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l + r) / 2;
        double pivot = arr[mid].price;

        swap(arr, l, mid);

        int last = l;

        for (int i = l + 1; i <= r; i++) {
            if (arr[i].price < pivot) {
                last++;
                swap(arr, last, i);
            }
        }
        swap(arr, l, last);
        quickSort(arr, l, last - 1);
        quickSort(arr, last + 1, r);
    }
}