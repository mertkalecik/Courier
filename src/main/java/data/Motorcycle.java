package data;

import org.codehaus.jackson.annotate.JsonSubTypes;


public class Motorcycle extends Vehicle {

    public Motorcycle() {
        super(1, "Motorcycle", 50, "45 FS 929");
    }
}
