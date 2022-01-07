package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<ReceiptItem> items = new ArrayList<>();

    public Double getTotalPrice() {
        double total = 0.0;
        for (ReceiptItem item : this.items) {
            total += item.getTotalPrice();
            total += item.getProduct().getDiscountAmount();
        }
        return total;
    }

    public void addProduct(Product p, double quantity, double price, double totalPrice) {
        this.items.add(new ReceiptItem(p, quantity, price, totalPrice));
    }

    public List<ReceiptItem> getItems() {
        return new ArrayList<>(this.items);
    }

    public StringBuilder presentItems() {
        StringBuilder result = new StringBuilder();
        for (ReceiptItem item : this.items) {
            String receiptItem = item.presentReceiptItem();
            result.append(receiptItem);
        }
        for (ReceiptItem item : this.items) {
            String discountPresentation = item.getProduct()presentDiscount();
            result.append(discountPresentation);
        }
        return result;
    }

    public String presentTotal() {
        String name = "Total: ";
        String value = Utils.presentPrice(this.getTotalPrice());
        return Utils.formatLineWithWhitespace(name, value);
    }
}
