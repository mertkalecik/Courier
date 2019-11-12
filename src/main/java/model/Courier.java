package model;


public class Courier extends Person {

    public Courier(int id, String username, String pass, String address) {
        super(id, username, pass, address);
    }

    @Override
    public String toString() {
        return "Courier";
    }
}
