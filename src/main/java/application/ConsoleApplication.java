package application;

import dao.TransactionDao;
import dao.UserDao;
import interfaces.Command;
import interfaces.ProjectData;
import model.AdminModel;
import model.BuyerModel;
import model.SellerModel;
import view.BuyerConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication implements Command {

	private UserDao userDao;
	private TransactionDao transactionDao;
	private AdminModel adminModel;
	private Scanner scanner;

	public ConsoleApplication() {
		userDao = new UserDao();
		transactionDao = new TransactionDao();
		scanner = new Scanner(System.in);
	}

	@Override
	public void run() {
		System.out.println("Console based Application is running...");

		BuyerModel buyerModel = new BuyerModel(userDao.getBuyer());

		SellerModel sellerModel = new SellerModel(buyerModel, userDao.getSeller());

		adminModel = new AdminModel(sellerModel, userDao);
		menu(buyerModel, sellerModel, adminModel);
		exit();
	}

	private int menu(BuyerModel buyerModel, SellerModel sellerModel, AdminModel adminModel) {
		System.out.println("-----------SELECT User Operation---------------------");
		System.out.println("1. Make Order - Buyer");
		System.out.println("2. Approve Order - Seller");
		System.out.println("3. Finalize Orders- Admin");
		System.out.println("-1. Exit...");

		int choice;
		while (true) {
			try {
				choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
					case -1:
						System.exit(0);
						break;
					case 1:
						BuyerConsoleView consoleView = new BuyerConsoleView(buyerModel);
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

}
