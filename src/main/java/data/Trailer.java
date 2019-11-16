package data;

import org.codehaus.jackson.annotate.JsonSubTypes;


public class Trailer extends Vehicle {

    public Trailer() {
        super(4, "Trailer", 500, "45 DB 572");
    }
}
