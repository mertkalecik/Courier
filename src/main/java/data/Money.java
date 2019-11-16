package data;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public Money( ) {
      this.money = 0;
    }

    public int getMoney() {
        return money;
    }

    public Money times(int quantity) {
        this.money *= quantity;
        return this;
    }

    public Money add(Money money) {
        this.money += money.getMoney();
        return this;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Money: " + money;
    }
}
