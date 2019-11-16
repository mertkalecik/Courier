package dao;

import interfaces.Dao;
import interfaces.ProjectData;
import data.Shipment;
import utils.JsonReader;
import utils.JsonWriter;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao implements Dao<Shipment> {

    private List<Shipment> transactions = new ArrayList<>();
    private JsonReader reader;
    private JsonWriter writer;


    public TransactionDao() {
        reader = new JsonReader();
        writer = new JsonWriter();
    }


    @Override
    public List<Shipment> getAll() {
        for (ProjectData pd: reader.read()) {
            transactions.add((Shipment) pd);
        }

        return transactions;
    }

    public void saveTransactions(List<ProjectData> shipmentList) {
        writer.write(shipmentList);
    }
}
