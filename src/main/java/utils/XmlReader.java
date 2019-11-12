package utils;

import interfaces.IFileReader;
import interfaces.ProjectData;
import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlReader implements IFileReader {

    private List<ProjectData> personList;

    public XmlReader() {
        personList = new ArrayList<ProjectData>();
    }

    @Override
    public List<ProjectData> read() {

        try {
            File fXmlFile = new File("src/main/person.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("person");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String id =  eElement.getAttribute("id");
                    String username = eElement.getElementsByTagName("username").item(0).getTextContent();
                    String pass = eElement.getElementsByTagName("pass").item(0).getTextContent();
                    String address = eElement.getElementsByTagName("address").item(0).getTextContent();

                    /*
                    System.out.println("Person id : " + id);
                    System.out.println("Username : " + username);
                    System.out.println("Password : " + pass);
                    System.out.println("Address : " + address); */

                    if (username.trim().equalsIgnoreCase("buyer")) {
                        personList.add(new Buyer(Integer.parseInt(id),username, pass, address));
                    } else if ((username.trim().equalsIgnoreCase("seller")))
                        personList.add(new Seller(Integer.parseInt(id), username, pass, address));
                    else
                        personList.add(new Courier(Integer.parseInt(id), username, pass, address));
                }
            }

            return personList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
