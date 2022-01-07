package dojo.supermarket;

import dojo.supermarket.model.*;

import java.util.Locale;

public class ReceiptPrinter {

    public String printReceipt(Receipt receipt) {
        StringBuilder result = new StringBuilder();
        result.append(receipt.presentItems());

        result.append("\n");
        result.append(receipt.presentTotal());
        return result.toString();
    }

    private String presentDiscount(Discount discount) {
        String name = discount.getDescription() + "(" + discount.getProduct().getName() + ")";
        String value = presentPrice(discount.getDiscountAmount());

        return formatLineWithWhitespace(name, value);
    }

}
