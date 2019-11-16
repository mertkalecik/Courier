package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog {

    private Map<Integer, ProductDescription> descriptions;
    private ProductDescription description;

    public ProductCatalog() {
        descriptions = new HashMap<>();

        /*ItemID id1 = ItemID.getInstance(100);
        ItemID id2 = ItemID.getInstance(200);
        ItemID id3 = ItemID.getInstance(300);
        ItemID id4 = ItemID.getInstance(400);*/

        Money price1 = new Money(15);
        Money price2 = new Money(30);
        Money price3 = new Money(45);
        Money price4 = new Money(60);



        Weight weight1 = new Weight(10);
        Weight weight2 = new Weight(20);
        Weight weight3 = new Weight(30);
        Weight weight4 = new Weight(50);



        description = new ProductDescription(100, price1, weight1, "Mouse", 2001);
        descriptions.put(100, description);
        description = new ProductDescription(200, price2, weight2, "Keyboard", 2001);
        descriptions.put(200, description);
        description = new ProductDescription(300, price3, weight3, "Speaker",2001);
        descriptions.put(300, description);
        description = new ProductDescription(400, price4, weight4, "Monitor",2001);
        descriptions.put(400, description);
    }

    public ProductDescription getDescription(String id) {
        ProductDescription description = descriptions.get(Integer.parseInt(id));
        System.out.println("Mert");

        return description;
    }

    public List<ProductDescription> getMyProducts(int myIdentity) {
        List<ProductDescription> myProducts = new ArrayList<>();

        for (Map.Entry<Integer, ProductDescription> entry: descriptions.entrySet()) {
            if (descriptions.get(entry.getKey()).getProductOwner() == myIdentity)
                myProducts.add(descriptions.get(entry.getKey()));
        }

        return myProducts;
    }

    public void addProduct(int itemId, Money price, Weight weight, String dsc, int productOwner) {
        description = new ProductDescription(itemId, price, weight, dsc, productOwner);
        descriptions.put(itemId, description);
    }

    public void deleteProduct(int itemID) {
        descriptions.remove(itemID);
    }
}
