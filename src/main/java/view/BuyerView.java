package view;

import model.BuyerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyerView extends PersonView {
    private BuyerModel buyerModel;
    private JTextField productIdText, quantityText;
    private JLabel productIdLabel, quantityLabel;
    private JButton add, complete;


    public BuyerView(String label, BuyerModel buyerModel, int h, int v) {
        super(label, h, v);
        this.buyerModel = buyerModel;
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        panel.setPreferredSize(new Dimension(250, 250));

        productIdText= new JTextField(22);
        quantityText = new JTextField(22);
        productIdLabel = new JLabel("Product ID:");
        quantityLabel = new JLabel("Quantity:");
        complete = new JButton("Complete");
        add = new JButton("Add");

        panel.add(productIdLabel);
        panel.add(productIdText);
        panel.add(quantityLabel);
        panel.add(quantityText);
        panel.add(add);
        panel.add(complete);

        add.addActionListener(new AddListener());
        complete.addActionListener(new CompleteListener());

        personFrame.add(panel);
        personFrame.setVisible(true);
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buyerModel.makeLineItem(productIdText.getText(), Integer.parseInt(quantityText.getText()));
        }
    }

    class CompleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            buyerModel.notifySellers();
        }
    }

}
