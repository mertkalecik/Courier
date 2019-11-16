package data;

public class Payment {

    private Money amount;

    public Payment(Money cashTendered) {
        amount = cashTendered;
    }

    public Payment() {
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Money getAmount() { return amount; }
}
