package dao;

import data.*;
import interfaces.Dao;
import interfaces.ProjectData;
import utils.XmlReader;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<Person> {

    private List<Person> users = new ArrayList<>();

    public UserDao() {
        XmlReader reader= new XmlReader();
        for (ProjectData p: reader.read()) {
            users.add((Person)p);
        }
    }

    @Override
    public List<Person> getAll() {
        return users;
    }

    public Seller getSeller() {
        return (Seller)users.get(1);
    }

    public Buyer getBuyer() {
        return (Buyer) users.get(0);
    }

    public Courier getCourier() {
        return (Courier) users.get(2);
    }

    public Admin getAdmin() {
        return new Admin(1, "admin", "admin", "Istanbul");
    }
}
