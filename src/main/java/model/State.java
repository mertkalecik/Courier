package model;

public class State {

    private OrderState state;

    public State() {
        state = OrderState.ORDERED;
    }

    public void changeState(OrderState newState) {
        this.state = newState;
    }

}
