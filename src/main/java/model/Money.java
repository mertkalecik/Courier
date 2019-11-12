package model;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public Money times(int quantity) {
        this.money *= quantity;
        return this;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
