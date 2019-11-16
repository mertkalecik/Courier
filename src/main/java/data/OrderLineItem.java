package data;

import org.codehaus.jackson.annotate.JsonIgnore;

public class OrderLineItem {

    private int quantity;
    private ProductDescription description;

    public OrderLineItem(int quantity, ProductDescription description) {
        this.quantity = quantity;
        this.description = description;
    }

    public OrderLineItem() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }

    @JsonIgnore
    public Money getSubTotal() {
        return description.getPrice().times(quantity);
    }

    @JsonIgnore
    public Weight getSubWeightTotal() {
        return description.getWeight();
    }
}
