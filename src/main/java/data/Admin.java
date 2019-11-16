package data;

public class Admin extends Person {

    public Admin(int id, String username, String pass, String address) {
        super(id, username, pass, address);
    }

    @Override
    public String toString() {
        return "Admin";
    }
}
