package utils;

import application.ConsoleApplication;
import application.RichClientApplication;
import interfaces.Command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
	
	public ConfigReader() {}

    String fileName = "src/main/java/config.txt";

    private String line = null;
    
    public Command getConfig() {
        try {
            FileReader fileReader = 
                new FileReader(fileName);

            @SuppressWarnings("resource")
			BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                switch (line) {
                    case "RichClientApplication":
                        return new RichClientApplication();
                    default:
                        return new ConsoleApplication();
                }
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }

        return new ConsoleApplication();
    }
}
