package data;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.*;

public class Order extends Observable {
    private Integer orderId;
    private String date;
    private State state;
    private Payment payment;
    private List<OrderLineItem> lineItems;

    public Order(Integer orderId, String date, State state, Payment payment, List<OrderLineItem> lineItems) {
        this.orderId = orderId;
        this.date = date;
        this.state = state;
        this.payment = payment;
        this.lineItems = lineItems;
    }

    Random rand = new Random();

    public Order() {
        this.lineItems = new ArrayList<>();
        this.payment = new Payment(new Money());
        this.state = new State();
        this.date = new Date().toString();
        this.orderId = rand.nextInt(50000);//Random orderId
    }

    @JsonIgnore
    public Money getTotal() {
        Money total = new Money();

        for (OrderLineItem o: lineItems) {
            total.add(o.getSubTotal());
        }

        return total;
    }

    @JsonIgnore
    public Weight getTotalWeight() {
        Weight total = new Weight();

        for (OrderLineItem o: lineItems) {
            total.addWeigt(o.getSubWeightTotal());
        }

        return total;
    }

    @JsonIgnore
    public void ChangeOrderState() {
        this.state.runOverStates();
    }

    @JsonIgnore
    public void makePayment(Money cashTendered, Money shipmentPrice) {
        payment = new Payment(cashTendered.add(shipmentPrice));
    }

    @JsonIgnore
    public void makePayment(Money cashTendered) {
        payment = new Payment(cashTendered);
    }

    @Override
    @JsonIgnore
    public String toString() {
        return "Order Id: " +this.getOrderId() + " State: " + state.toString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<OrderLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

}
