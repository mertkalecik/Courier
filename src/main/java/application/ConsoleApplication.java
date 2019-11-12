package application;

import interfaces.Command;

public class ConsoleApplication implements Command {

	public ConsoleApplication() {
		
	}

	@Override
	public void run() {
		System.out.println("Console based Application is running...");
	}

	@Override
	public void exit() {

	}

}
