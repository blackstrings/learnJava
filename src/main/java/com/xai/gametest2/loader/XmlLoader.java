package com.xai.gametest2.loader;

import java.util.HashMap;
import java.util.Map;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;

// Read more: http://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html#ixzz37PTG1dXI

// read more here
// http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/

//TODO
// need to figure out how to read node names not their values

/**
 * This is a static class with static methods it helps load data from xml and
 * parse it into a hashmap it can access specific xml files if specify
 * 
 *
 */
public class XmlLoader extends Loader {

	public static Map<String, Object> getById(int id, String file) {

		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	//testing
	public static void main(String[] args) {

		try {

			File file = new File("Res/item.xml");

			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();

			Document doc = dBuilder.parse(file);

			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

			if (doc.hasChildNodes()) {

				printNote(doc.getChildNodes());
				
				// TODO figure this out and you will be able to get the node name
				//NodeList nodeList1 = doc.getChildNodes();
				
				//NodeList nodeList2 = nodeList1.item(0).getChildNodes();
				
				//System.out.println( nodeList2.item(0).getNodeName() );

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void printNote(NodeList nodeList) {

		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());

				
				/*
				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();

					for (int i = 0; i < nodeMap.getLength(); i++) {

						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : "
								+ node.getNodeValue());

					}

				}
				*/

				
				if (tempNode.hasChildNodes()) {

					// loop again if has child nodes
					printNote(tempNode.getChildNodes());

				}
				

				System.out.println("Node Name =" + tempNode.getNodeName()
						+ " [CLOSE]");

			}

		}

	}

	/**
	 * Read xml and just get values
	 */
	/*
	 * public static void main(String args[]) { try {
	 * 
	 * String filename = "Res/item.xml"; String elementRootName = "items";
	 * String elementName = "item";
	 * 
	 * File items = new File(filename); DocumentBuilderFactory dbFactory =
	 * DocumentBuilderFactory .newInstance(); DocumentBuilder dBuilder =
	 * dbFactory.newDocumentBuilder();
	 * 
	 * Document doc = dBuilder.parse(items);
	 * doc.getDocumentElement().normalize();
	 * 
	 * System.out.println("root of xml file" +
	 * doc.getDocumentElement().getNodeName()); NodeList nodes =
	 * doc.getElementsByTagName(elementName);
	 * System.out.println("==========================");
	 * 
	 * for (int i = 0; i < nodes.getLength(); i++) { Node node = nodes.item(i);
	 * 
	 * if (node.getNodeType() == Node.ELEMENT_NODE) { Element element =
	 * (Element) node; System.out.println("" + node.getNodeName() + " : " +
	 * getValue("id", element)); System.out.println("Name: " + getValue("name",
	 * element)); System.out.println("Price: " + getValue("price", element));
	 * System.out.println("Stack: " + getValue("stack", element)); } } } catch
	 * (Exception ex) { ex.printStackTrace(); } }
	 * 
	 * private static String getValue(String tag, Element element) { NodeList
	 * nodes = element.getElementsByTagName(tag).item(0).getChildNodes(); Node
	 * node = (Node) nodes.item(0); return node.getNodeValue(); }
	 */

}
