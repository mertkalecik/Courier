package view;

import data.Order;
import data.Shipment;
import model.AdminModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AdminView extends PersonView implements Observer {
    private AdminModel adminModel;

    private JLabel labelOrder;
    private JList listOrder;
    private JButton orderButton;
    private JPanel orderPanel;

    private JLabel labelShipment;
    private JList listShipment;
    private JButton shipmentButton;
    private JPanel shipmentPanel;


    public AdminView(String label,AdminModel adminModel, int h, int v) {
        super(label, h, v);
        super.personFrame.setBounds(700,150,500,500);
        this.adminModel = adminModel;
        adminModel.addObserver(this);

        personFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        personFrame.setPreferredSize(new Dimension(500, 500));
        orderPanel = new JPanel();
        orderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        orderPanel.setPreferredSize(new Dimension(250, 250));
        labelOrder = new JLabel("Select an order:");
        listOrder = new JList();
        orderButton = new JButton("Create");

        orderPanel.add(labelOrder);
        orderPanel.add(listOrder);
        orderPanel.add(orderButton);

        shipmentPanel = new JPanel();
        shipmentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        shipmentPanel.setPreferredSize(new Dimension(250, 250));
        labelShipment = new JLabel("Select a shipment:");
        listShipment = new JList();
        shipmentButton = new JButton("Finalize");

        shipmentPanel.add(labelShipment);
        shipmentPanel.add(listShipment);
        shipmentPanel.add(shipmentButton);

        personFrame.add(orderPanel);
        personFrame.add(shipmentPanel);
        personFrame.setVisible(true);

        orderButton.addActionListener(new OrderListener());
        shipmentButton.addActionListener(new FinalizeListener());

    }

    class OrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminModel.createShipment(listOrder.getSelectedIndex());

            System.out.println("Shipment is created...");
        }
    }

    class FinalizeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Shipment is finalized...");
            adminModel.finalizeShipment(listShipment.getSelectedIndex());
        }
    }

    private void updateOrder(List<Order> list) {
        Order[] orders = list.toArray(new Order[0]);
        listOrder.setListData(orders);

        orderPanel.invalidate();
        orderPanel.validate();
        orderPanel.repaint();
    }

    private void updateOrderList() {
        orderPanel.invalidate();
        orderPanel.validate();
        orderPanel.repaint();
    }

    private void updateShipment(List<Shipment> list) {
        Shipment[] shipments = list.toArray(new Shipment[0]);
        listShipment.setListData(shipments);

        shipmentPanel.invalidate();
        shipmentPanel.validate();
        shipmentPanel.repaint();
    }


    @Override
    public void update(Observable o, Object arg) {
        List<Object> objects = (List<Object>)arg;

        if(!objects.isEmpty() && objects.get(0) instanceof Order) {
            List<Order> list = (List<Order>) arg;
            updateOrder(list);
        } else {
            List<Shipment> list = (List<Shipment>) arg;
            updateShipment(list);
            updateOrderList();
        }
    }
}
