package model;

public class ProductDescription {

    private ItemID id;
    private Money price;
    private Weight weight;
    private String description;

    public ProductDescription(ItemID id, Money price, Weight weight, String description) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.description = description;
    }

    public ItemID getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public Weight getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }
}
