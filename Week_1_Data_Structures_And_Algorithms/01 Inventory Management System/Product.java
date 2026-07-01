public class Product {
    private int id;
    private String name;
    private int qty;
    private double cost;

    public Product(int i, String n, int q, double c) {
        id = i;
        name = n;
        qty = q;
        cost = c;
    }

    public int getProductId() {
        return id;
    }

    public void setProductId(int i) {
        id = i;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String n) {
        name = n;
    }

    public int getQuantity() {
        return qty;
    }

    public void setQuantity(int q) {
        qty = q;
    }

    public double getPrice() {
        return cost;
    }

    public void setPrice(double c) {
        cost = c;
    }

    @Override
    public String toString() {
        return "Product [productId=" + id + ", productName=" + name + ", quantity=" + qty + ", price=" + cost + "]";
    }
}