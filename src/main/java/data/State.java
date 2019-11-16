package data;

public class State {

    private OrderState state;

    public State() {
        state = OrderState.ORDERED;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void changeState(OrderState state) {
        this.state = state;
        System.out.println(this.state.toString());
    }

    @Override
    public String toString() {
        return state.toString();
    }

    public void runOverStates() {
        Thread orderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    changeState(OrderState.LOADED);
                    Thread.sleep(2000);
                    changeState(OrderState.INTRANSFER);
                    Thread.sleep(2000);
                    changeState(OrderState.RECEIVED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        orderThread.run();

    }

}
