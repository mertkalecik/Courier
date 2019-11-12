package model;

public class OrderLineItem {

    private int quantity;
    private ProductDescription description;

    public OrderLineItem(int quantity, ProductDescription description) {
        this.quantity = quantity;
        this.description = description;
    }

    public Money getSubTotal() {
        return description.getPrice().times(quantity);
    }
}
