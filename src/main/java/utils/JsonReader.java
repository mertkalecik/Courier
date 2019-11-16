package utils;

import interfaces.IFileReader;
import interfaces.ProjectData;
import data.Shipment;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader implements IFileReader {
    private List<ProjectData> transactions;

    public JsonReader() {
    }

    @Override
    public List<ProjectData> read() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            transactions =  mapper.readValue(new File("src/main/transaction.json"), new TypeReference<List<Shipment>>(){});
            System.out.println("Counter: " + transactions.size());
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

}
