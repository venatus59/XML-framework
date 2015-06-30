import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.io.File;
/**
 * 
 */

/**
 * @author ActualAdmin
 *
 */
public class XMLParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			File testXML = new File("staff.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(testXML);
			
			doc.getDocumentElement().normalize();
			
			System.out.println("root element :"+ doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("staff");
			
			System.out.println("-----------------");
			
			for (int temp = 0; temp < nList.getLength(); temp++){
				Node nNode = nList.item(temp);
				
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
				
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;

					if(Double.parseDouble(eElement.getElementsByTagName("salary").item(0).getTextContent())>=20000000){
						System.out.println(eElement.getElementsByTagName("firstname").item(0).getTextContent()+" the high goddess of all reality");
					}
					else{

						System.out.println("Staff id : " + eElement.getAttribute("id"));

						System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
						System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
						System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
						System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
					}
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}
