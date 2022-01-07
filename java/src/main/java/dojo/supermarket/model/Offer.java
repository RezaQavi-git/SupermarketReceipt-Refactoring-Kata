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
    public void handleTwoForAmountoOffer(Product p, double totalPrice, int quantityAsInt, double unitPrice){
        int x = 2;
        int numberOfXs = quantityAsInt / x;
        if (quantityAsInt >= 2) {
            double discountAmount = totalPrice - (this.argument * numberOfXs + quantityAsInt % 2 * unitPrice);
            p.setDiscountDescription("2 for " + this.argument);
            p.setDiscountAmount(-discountAmount);
        }
    }
    public void handleFiveForAmountOffer(Product p, double totalPrice, int quantityAsInt, double unitPrice){
        int x = 5;
        int numberOfXs = quantityAsInt / x;
        if (quantityAsInt >= 5) {
            double discountAmount = totalPrice - (this.argument * numberOfXs + quantityAsInt % 5 * unitPrice);
            p.setDiscountDescription("5 for " + this.argument);
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
            handleTwoForAmountoOffer(p, totalPrice, quantityAsInt, unitPrice);
        } else if(this.offerType == SpecialOfferType.FiveForAmount) {
            handleFiveForAmountOffer(p, totalPrice, quantityAsInt, unitPrice);
        } else if(this.offerType == SpecialOfferType.TenPercentDiscount) {
            handleTenPercentDiscountOffer(p, totalPrice);
        }
    }

}

