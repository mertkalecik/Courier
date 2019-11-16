package application;

import dao.TransactionDao;
import dao.UserDao;
import interfaces.Command;
import interfaces.ProjectData;
import model.*;
import utils.JsonReader;
import utils.JsonWriter;
import view.AdminView;
import view.BuyerView;
import view.SellerView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class RichClientApplication implements Command, Observer {

	private UserDao userDao;
	private TransactionDao transactionDao;
	private AdminModel adminModel;

	public RichClientApplication() {
		userDao = new UserDao();
		transactionDao = new TransactionDao();
	}

	@Override
	public void run() {
		System.out.println("Rich Client based application is Running...");

		BuyerModel buyerModel = new BuyerModel(userDao.getBuyer());
		BuyerView buyerView = new BuyerView("Buyer", buyerModel,200, 150);

		SellerModel sellerModel = new SellerModel(buyerModel, userDao.getSeller());
		SellerView sellerView = new SellerView("Seller", sellerModel,450, 150);

		adminModel = new AdminModel(sellerModel, userDao);
		AdminView adminView = new AdminView("Admin", adminModel, 700, 150);
		adminModel.setOrderList(transactionDao.getAll());
		exit();
	}

	@Override
	public void exit() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				List<ProjectData> list = new ArrayList<>(adminModel.getShipmentList());
				transactionDao.saveTransactions(list);
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		exit();
	}
}
