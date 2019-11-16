package data;

public class Weight {
    private int weight;

    public Weight(int weight) {
        this.weight = weight;
    }

    public Weight() {

    }

    public int getWeight() {
        return weight;
    }

    public Weight addWeigt(Weight w) {
        this.weight += w.getWeight();
        return this;
    }

    public Weight times(int quantity) {
        this.weight *= quantity;
        return this;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
