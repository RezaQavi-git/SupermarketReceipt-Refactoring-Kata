package dojo.supermarket.model;

import java.util.Objects;

public class ReceiptItem {
    private final Product product;
    private final double price;
    private double totalPrice;
    private final double quantity;

    ReceiptItem(Product p, double quantity, double price, double totalPrice) {
        this.product = p;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public String presentReceiptItem() {
        String totalPricePresentation = Utils.presentPrice(this.getTotalPrice());
        String name = this.product.getName();

        String line = Utils.formatLineWithWhitespace(name, totalPricePresentation);

        if (this.quantity != 1) {
            line += "  " + Utils.presentPrice(this.price) + " * " + this.presentQuantity() + "\n";
        }
        return line;
    }

    private String presentQuantity() {
        String result = "";
        if(ProductUnit.Each == this.product.getUnit()) {
            result = String.format("%x", (int)this.quantity);
        } else {
            result = String.format(Locale.UK, "%.3f", this.quantity);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItem that = (ReceiptItem) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.totalPrice, totalPrice) == 0 &&
                Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product, price, totalPrice, quantity);
    }


}
