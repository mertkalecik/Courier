package model;

import data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class BuyerModel extends Observable {
    List<Observer> observers = new ArrayList<>();
    private ProductCatalog catalog;
    private Buyer buyer;
    private Order order;

    public BuyerModel(Buyer buyer) {
        order = new Order();
        catalog = new ProductCatalog();
        this.buyer = buyer;
    }

    private void makePayment(Money cashTendered) {
        order.makePayment(cashTendered);
    }

    private void makeNewOrder() {
        this.order = new Order();
    }

    public void makeLineItem(String id, int quantity) {
        ProductDescription description = catalog.getDescription(id);
        order.getLineItems().add(new OrderLineItem(quantity, description));
    }

    void registerObserver(Observer o) {
        observers.add(o);
    }

    void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    public void notifySellers() {
        makePayment(order.getTotal());
        for (Observer o: observers) {
            o.update(this, order);
        }
        makeNewOrder();
    }
}
