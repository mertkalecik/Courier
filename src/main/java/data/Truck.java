package data;

import org.codehaus.jackson.annotate.JsonSubTypes;

@JsonSubTypes({
        @JsonSubTypes.Type(value = Motorcycle.class, name = "Motorcycle"),
        @JsonSubTypes.Type(value = Van.class, name = "Van"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck"),
        @JsonSubTypes.Type(value = Trailer.class, name = "Motorcycle")}
)
public class Truck extends Vehicle {

    public Truck() {
        super(3, "Truck", 200, "45 AR 453");
    }

}
