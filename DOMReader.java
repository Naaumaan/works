package com.dom.reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMReader {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException    {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new File("E:\\webservices\\DOMPrinter\\resource\\purchase-order.xml"));
		Node node = doc.getFirstChild();
		read(doc);
	
	}
	
	  public static void read(Node node ) {
		if (node!=null) {
			int type = node.getNodeType();
			if (type ==node.DOCUMENT_NODE) {
				read(node.getFirstChild());
			}
			if (type ==node.ELEMENT_NODE) {
				System.out.print("<"+node.getNodeName()+">");
				NodeList children =  node.getChildNodes();
				if(children!=null) {
					for(int i =0 ; i<children.getLength(); i++) {
						Node child = children.item(i);
						read(child);
					}
				}
				System.out.println("</"+node.getNodeName()+">");
				
			}	
			
		
			if (node!=null) {
				if(type ==node.TEXT_NODE){
					System.out.print(node.getNodeValue());
				}
			}
			
		}
	  }
		
		
}