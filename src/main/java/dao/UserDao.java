package dao;

import interfaces.Dao;
import interfaces.ProjectData;
import model.*;
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
        return null;
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
}
