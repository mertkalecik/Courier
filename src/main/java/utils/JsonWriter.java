package utils;

import data.Shipment;
import interfaces.IFileWriter;
import interfaces.ProjectData;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter implements IFileWriter {

    private ObjectMapper objectMapper;

    public JsonWriter( ) {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Override
    public void write(List<ProjectData> dataList) {
        List<Shipment> shipments = getShipmentList1(dataList);

        try {
            objectMapper.writeValue(new File("src/main/transaction.json"), shipments);
        }  catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Shipment> getShipmentList1(List<ProjectData> dataList) {
        List<Shipment> list = new ArrayList<>();

        for (ProjectData pd: dataList) {
            list.add((Shipment)pd);
        }

        return list;
    }
}
