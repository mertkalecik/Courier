package model;

import dao.UserDao;
import data.*;

import java.util.*;

public class AdminModel extends Observable implements Observer {
    private List<Observer> observers;
    private SellerModel sellerModel;
    private List<Order> orderList;
    private List<Shipment> shipmentList;
    private UserDao userDao;
    private Random random;

    public AdminModel(SellerModel sellerModel, UserDao userDao) {
        this.sellerModel = sellerModel;
        sellerModel.registerObserver(this);
        this.userDao = userDao;
        orderList = new ArrayList<>();
        shipmentList = new ArrayList<>();
        observers = new ArrayList<>();
        registerObserver(this);
        random = new Random();
    }

    void registerObserver(Observer o) {
        observers.add(o);
    }

    void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    public void createShipment(int orderId) {
        Order order = orderList.get(orderId);

        shipmentList.add(new Shipment(random.nextInt(50000),
                order,
                userDao.getSeller(),
                userDao.getBuyer(),
                userDao.getCourier(),
                selectVehicle(order),
                new Money(10)));


        setChanged();
        notifyObservers(shipmentList);
    }

    public void setOrderList(List<Shipment> shipments) {
        this.shipmentList.addAll(shipments);
        setChanged();
        notifyObservers(shipmentList);
    }

    public List<Shipment> getShipmentList() {
        return shipmentList;
    }

    public void finalizeShipment(int shipmentId) {
        Shipment shipment = shipmentList.get(shipmentId);

        shipment.getOrder().getState().runOverStates();

        setChanged();
        notifyObservers(shipmentList);
        sellerModel.refreshLayout();
    }

    public Vehicle selectVehicle(Order order) {
        int orderWeight = order.getTotalWeight().getWeight();
        if (orderWeight < 51) {
            return new Motorcycle();
        } else if (orderWeight < 101) {
            return new Van();
        } else if (orderWeight < 201) {
            return new Truck();
        } else {
            return new Trailer();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o != null)
            orderList.add((Order) arg);

        setChanged();
        notifyObservers(orderList);
    }
}
