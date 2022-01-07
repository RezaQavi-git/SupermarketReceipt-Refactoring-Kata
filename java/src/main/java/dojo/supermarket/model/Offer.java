package dojo.supermarket.model;

public class Offer {
    SpecialOfferType offerType;
    private final Product product;
    double argument;

    public Offer(SpecialOfferType offerType, Product product, double argument) {
        this.offerType = offerType;
        this.argument = argument;
        this.product = product;
    }

    Product getProduct() {
        return this.product;
    }

    public void handleThreeForTwoOffer(Product p, double totalPrice, int quantityAsInt, double unitPrice){
        int x = 3;
        int numberOfXs = quantityAsInt / x;
        if (quantityAsInt > 2) {
            double discountAmount = totalPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
            p.setDiscountDescription("3 for 2");
            p.setDiscountAmount(-discountAmount);
        }
    }

    public void handleForAmountOffer(Product p, double totalPrice, int quantityAsInt, double unitPrice, int x){
        int numberOfXs = quantityAsInt / x;
        if (quantityAsInt >= x) {
            double discountAmount = totalPrice - (this.argument * numberOfXs + quantityAsInt % x * unitPrice);
            p.setDiscountDescription(x + " for " + this.argument);
            p.setDiscountAmount(-discountAmount);
        }
    }

    public void handleTenPercentDiscountOffer(Product p, double totalPrice){
        p.setDiscountDescription(this.argument + "% off");
        p.setDiscountAmount(-totalPrice * this.argument / 100.0);
    }


    public void calculateDiscount(Product p, double quantity, double unitPrice) {
        int quantityAsInt = (int) quantity;
        int numberOfXs;

        double totalPrice = quantity * unitPrice;

        if(this.offerType == SpecialOfferType.ThreeForTwo) {
            handleThreeForTwoOffer(p, totalPrice, quantityAsInt, unitPrice);
        } else if(this.offerType == SpecialOfferType.TwoForAmount) {
            handleForAmountOffer(p, totalPrice, quantityAsInt, unitPrice, 2);
        } else if(this.offerType == SpecialOfferType.FiveForAmount) {
            handleForAmountOffer(p, totalPrice, quantityAsInt, unitPrice, 5);
        } else if(this.offerType == SpecialOfferType.TenPercentDiscount) {
            handleTenPercentDiscountOffer(p, totalPrice);
        }
    }

}

