import interfaces.Command;
import utils.ConfigReader;

public class Main {

	public static void main(String[] args) {
		Command application;

		ConfigReader reader = new ConfigReader();
		application = reader.getConfig();
		application.run();
	}
}
