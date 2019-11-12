package model;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private Map<ItemID, ProductDescription> descriptions = new HashMap<ItemID, ProductDescription>();

    public ProductCatalog(Map<ItemID, ProductDescription> descriptions) {

        ItemID id1 = new ItemID(100);
        ItemID id2 = new ItemID(100);
        ItemID id3 = new ItemID(100);
        ItemID id4 = new ItemID(100);

        Money price1 = new Money(15);
        Money price2 = new Money(30);
        Money price3 = new Money(45);
        Money price4 = new Money(60);



        Weight weight1 = new Weight(10);
        Weight weight2 = new Weight(20);
        Weight weight3 = new Weight(30);
        Weight weight4 = new Weight(50);


        ProductDescription description;
        description = new ProductDescription(id1, price1, weight1, "Mouse");
        descriptions.put(id1, description);
        description = new ProductDescription(id2, price2, weight2, "Keyboard");
        descriptions.put(id2, description);
        description = new ProductDescription(id3, price3, weight3, "Speaker");
        descriptions.put(id3, description);
        description = new ProductDescription(id4, price4, weight4, "Monitor");
        descriptions.put(id4, description);
    }
}
