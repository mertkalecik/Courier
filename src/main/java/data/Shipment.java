package data;

import interfaces.ProjectData;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;

public class Shipment implements ProjectData {
    private Integer shipmentId;
    private Order order;
    private Seller seller;
    private Buyer buyer;
    private Courier courier;
    @JsonIgnore
    private Vehicle vehicle;
    private Money shipmentPrice;

    public Shipment(Integer shipmentId,Order order, Seller seller, Buyer buyer, Courier courier, Vehicle vehicle, Money shipmentPrice) {
        this.shipmentId = shipmentId;
        this.order = order;
        this.seller = seller;
        this.buyer = buyer;
        this.courier = courier;
        this.vehicle = vehicle;
        this.shipmentPrice = shipmentPrice;
    }

    public Shipment() {}

    @Override
    public String toString() {
        return "Shipment: " + shipmentId + "Order Id: " + order.getOrderId()+
                "State: " + order.getState().toString();
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Money getShipmentPrice() {
        return shipmentPrice;
    }

    public void setShipmentPrice(Money shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
