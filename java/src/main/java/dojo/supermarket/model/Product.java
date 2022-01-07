package dojo.supermarket.model;

import java.util.Objects;

public class Product {
    private final String name;
    private final ProductUnit unit;
    private String discountDescription;
    private double discountAmount;

    public Product(String name, ProductUnit unit) {
        this.name = name;
        this.unit = unit;
        this.discountAmount = 0;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public String getName() {
        return name;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    public void setDiscountDescription(String _discountDescription) {
        this.discountDescription = _discountDescription;
    }

    public void setDiscountAmount(double _discountAmount) {
        this.discountAmount = _discountAmount;
    }

    public String presentDiscount() {
        String name = this.discountDescription + "(" + this.name + ")";
        String value = Utils.presentPrice(this.discountAmount);

        return Utils.formatLineWithWhitespace(name, value);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                unit == product.unit;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, unit);
    }
}
