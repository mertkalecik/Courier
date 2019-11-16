package view;

import data.Order;
import model.SellerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SellerView extends PersonView implements Observer {
    private SellerModel sellerModel;
    private JButton approve;
    private JList jList;
    private JLabel jLabel;
    private JPanel jPanel;

    public SellerView(String label, SellerModel sellerModel, int h, int v) {
        super(label, h, v);
        this.sellerModel = sellerModel;
        jPanel = new JPanel();
        sellerModel.addObserver(this);
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        jPanel.setPreferredSize(new Dimension(250, 250));

        jLabel = new JLabel("Select the order id to approve:");

        approve = new JButton("Approve");
        jList = new JList();

        jPanel.add(jLabel);
        jPanel.add(jList);
        jPanel.add(approve);

        personFrame.add(jPanel);
        personFrame.setVisible(true);
        approve.addActionListener(new ApproveListener());
    }

    @Override
    public void update(Observable o, Object arg) {
        List<Order> list = (List<Order>) arg;
        Order[] orders = list.toArray(new Order[0]);
        jList.setListData(orders);

        jPanel.invalidate();
        jPanel.validate();
        jPanel.repaint();
    }

    class ApproveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            sellerModel.approveOrder(jList.getSelectedIndex());
        }
    }
}
