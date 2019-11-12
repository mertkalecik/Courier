package model;

public class Seller extends Person {
    public Seller(int id, String username, String pass, String address) {
        super(id, username, pass, address);
    }

    @Override
    public String toString() {
        return "Seller";
    }
}
