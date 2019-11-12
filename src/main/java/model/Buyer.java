package model;

public class Buyer extends Person {

    public Buyer(int id, String username, String pass, String address) {
        super(id, username, pass, address);
    }

    @Override
    public String toString() {
        return "Buyer";
    }
}
