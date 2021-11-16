public class Product {
    private String name;
    private double price;
    TaxPercentage taxPercentage;

    public Product(String name, double price, TaxPercentage taxPercentage) {
        this.name = name;
        this.price = price;
        this.taxPercentage = taxPercentage;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public TaxPercentage getTaxPercentage() {
        return taxPercentage;
    }
}
