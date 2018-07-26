package com.myproject.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 * @author Poonkodi Ponnambalam
 * Assignment 2 for CS218 
 */
public class XMLUtils {

	/*
	 * Parses the XML request and returns a map of key-values
	 */

	public static Map<String, Object> parseXmlFile(HttpServletRequest request) throws IOException {

		String body_text = getBody(request);
		return parseXmlFile(body_text);
	}
	/*
	 * Parses the XML string and returns a map of key-values
	 */
	public static Map<String, Object> parseXmlFile(String body_text) throws IOException {

		Map<String, Object> xmlmap= new HashMap<String, Object>();
		try {
			DocumentBuilderFactory docbuildfact = DocumentBuilderFactory.newInstance();
			//Using factory get an instance of document builder
			DocumentBuilder docbuild = docbuildfact.newDocumentBuilder();
			//parse using builder to get DOM representation of the XML file
			Document doc = docbuild.parse(new InputSource(new StringReader(body_text)));
			Element docEle = doc.getDocumentElement();
			//get a nodelist of  elements
			NodeList nlist=docEle.getChildNodes();
			int node_len = nlist.getLength();
			Node n;
			for(int i=0;i<node_len;i++)			
			{
				n=nlist.item(i);
				if(n.getNodeType()==1)
				{
					String node_name = n.getNodeName().toString(); 
					String node_val = n.getTextContent().toString();

					if (node_name.equals("id")) {
						int parsed_id = Integer.parseInt(node_val);
						xmlmap.put(node_name, parsed_id);
					} else if (node_name.equals("budget")) {
						Double parsed_budget = Double.parseDouble(node_val);
						xmlmap.put(node_name, parsed_budget);
					} else {
						xmlmap.put(node_name, node_val);
					}
				}
			}	
		}
		catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return xmlmap;
	}

	public static void main(String[] args) throws Exception {
		String xml_str = "<project><id>1234</id><name>poonkodi</name><budget>1235.23</budget></project>";
		Map<String, Object> xml_map = parseXmlFile(xml_str);
		for( Entry<String,Object> e : xml_map.entrySet())
		{
			System.out.println(e.getKey() + " : " +  e.getValue());
		}

	}

	/*
	 * @returns the XML payload from the HTTP request
	 * Credits: I referred to stackoverflow.com to parse the xml post request.
	 */
	public static String getBody(HttpServletRequest request) throws IOException {

		String body_string = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;

		try {
			InputStream is = request.getInputStream();
			if (is != null) {
				br = new BufferedReader(new InputStreamReader(is));
				char[] cb = new char[128];
				int bytes = -1;
				while ((bytes = br.read(cb)) > 0) {
					sb.append(cb, 0, bytes);
				}
			} else {
				sb.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ex) {
					throw ex;				
				}
			}
		}

		body_string = sb.toString();
		return body_string;
	}

}