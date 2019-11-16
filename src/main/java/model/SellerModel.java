package model;

import data.Order;
import data.OrderState;
import data.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SellerModel extends Observable implements Observer {
    List<Observer> observers = new ArrayList<>();
    private BuyerModel buyerModel;
    private Seller seller;
    private List<Order> orderList;

    public SellerModel(BuyerModel buyerModel, Seller seller) {
        this.buyerModel = buyerModel;
        buyerModel.registerObserver(this);
        orderList = new ArrayList<>();
    }

    void registerObserver(Observer o) {
        observers.add(o);
    }

    void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o !=null)
            orderList.add((Order) arg);
        System.out.println("Çalışıyor...");

        setChanged();
        notifyObservers(orderList);
    }

    public void refreshLayout() {
        setChanged();
        notifyObservers(orderList);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void approveOrder(int orderId) {
        for (Observer o: observers) {
            orderList.get(orderId).getState().changeState(OrderState.PAID);
            o.update(this, orderList.get(orderId));
        }

        setChanged();
        notifyObservers(orderList);
    }
}
