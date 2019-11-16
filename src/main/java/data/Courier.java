package data;


public class Courier extends Person {

    public Courier(int id, String username, String pass, String address) {
        super(id, username, pass, address);
    }

    public Courier() {

    }

    @Override
    public String toString() {
        return "Courier";
    }
}
