package data;

public class ProductDescription {

    private int id;
    private Money price;
    private Weight weight;
    private String description;
    private int productOwner;

    public ProductDescription(int id, Money price, Weight weight, String description, int productOwner) {
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.description = description;
        this.productOwner = productOwner;
    }

    public ProductDescription() {
    }

    public int getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(int productOwner) {
        this.productOwner = productOwner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
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
