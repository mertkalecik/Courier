package data;

import org.codehaus.jackson.annotate.JsonSubTypes;

public class Van extends Vehicle {

    public Van() {
        super(2, "Van", 100, "35 AGU 144");
    }

}
