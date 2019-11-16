package data;

public class Seller extends Person {

    public Seller(int id, String username, String pass, String address) {
        super(id, username, pass, address);
    }

    public Seller() {

    }

    @Override
    public String toString() {
        return "Seller";
    }
}
