package data;


import org.codehaus.jackson.annotate.JsonSubTypes;

public abstract class Vehicle {
    private int id;
    private String type;
    private int capacity;
    private String  plateNumber;

    public Vehicle(int id, String type, int capacity, String plateNumber) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
        this.plateNumber = plateNumber;
    }

    public Vehicle() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
