package application;

import dao.UserDao;
import interfaces.Command;

public class RichClientApplication implements Command {
	
	public RichClientApplication() {
		
	}

	@Override
	public void run() {
		System.out.println("Rich Client based application is Running...");
		UserDao dao = new UserDao();

		System.out.println(dao.getBuyer().getAddress());
		System.out.println(dao.getSeller().getAddress());
		System.out.println(dao.getCourier().getAddress());
	}

	@Override
	public void exit() {

	}

}
