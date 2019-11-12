package model;


import interfaces.ProjectData;

public abstract class Person implements ProjectData {
    private int id;
    private String username;
    private String pass;
    private String address;

    public Person(int id, String username, String pass, String address) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
