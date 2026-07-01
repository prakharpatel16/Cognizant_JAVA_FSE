import java.util.Arrays;

public class BookSearch {

    public static void main(String[] args) {
        Book[] arr = {
            new Book(1, "Java Programming", "Prakhar Patel"),
            new Book(2, "Data Structures", "Pranjal Pachauri"),
            new Book(3, "Algorithms", "Harsh Sharma"),
            new Book(4, "Operating Systems", "Aman Singh")
        };

        String key = "Data Structures";

        Book b = linearSearch(arr, key);
        System.out.println("Linear Search Result: " + (b != null ? b : "Not Found"));

        Arrays.sort(arr, (a, c) -> a.getTitle().compareTo(c.getTitle()));

        b = binarySearch(arr, key);
        System.out.println("Binary Search Result: " + (b != null ? b : "Not Found"));
    }

    public static Book linearSearch(Book[] arr, String key) {
        for (Book b : arr) {
            if (b.getTitle().equalsIgnoreCase(key)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] arr, String key) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int cmp = arr[m].getTitle().compareToIgnoreCase(key);

            if (cmp == 0) {
                return arr[m];
            } else if (cmp < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return null;
    }
}