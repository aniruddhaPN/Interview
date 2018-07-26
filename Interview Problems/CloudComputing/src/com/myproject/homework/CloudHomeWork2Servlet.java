package com.myproject.homework;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 * @author Poonkodi Ponnambalam
 * 
 *
 */
@SuppressWarnings("serial")
public class CloudHomeWork2Servlet extends HttpServlet {
	static DatastoreService datastore= DatastoreServiceFactory.getDatastoreService();

	/*
	 * creates an entity in the datastore 
	 * Error: if entity already found
	 * Success: if entity not found and creates the entity
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String path_info = req.getPathInfo();
		String str[]=path_info.split("/");
		if(str.length > 2 || !isValidType(str[1]) ) {
			resp.sendError(resp.SC_NOT_FOUND, " Invalid req format: " + str );
		}

		Map<String,Object> xmlmap = XMLUtils.parseXmlFile(req);
		if(!xmlmap.containsKey("id"))
		{
			resp.sendError(resp.SC_BAD_REQUEST,"Request is missing unique id");
			return;
		}
		//Find if id is already in the object
		Key k1 = KeyFactory.createKey(str[1],(int) xmlmap.get("id"));
		try {
			Entity e  = datastore.get(k1);
			resp.sendError(resp.SC_CONFLICT, "Entity already exists");
		}
		catch (EntityNotFoundException e) {
			AddEntity(str[1], xmlmap);
			resp.setStatus(resp.SC_CREATED);
		}	
	}

	/*
	 * Updates an entity in the datastore based on id in URI
	 * Error: if entity not found
	 * Success: if entity found and updates the entity
	 */
	public void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String path_info = req.getPathInfo();
		String str[]=path_info.split("/");
		if(str.length < 2 || !isValidType(str[1])) {
			resp.sendError(resp.SC_NOT_FOUND, str[1]+" Invalid req format: " );
		}

		Map<String,Object> xmlmap=XMLUtils.parseXmlFile(req);
		int parsed_id = Integer.parseInt(str[2]);
		Key k1 = KeyFactory.createKey(str[1],parsed_id);
		try {
			Entity en = datastore.get(k1);
			for( Entry<String,Object> e :xmlmap.entrySet())
			{
				en.setProperty(e.getKey(), e.getValue());
			}
			datastore.put(en);
			System.out.println("employee Updated " + en.toString());

			resp.setContentType("text/plain");
			resp.setStatus(resp.SC_OK);
			resp.getWriter().println("Update record successful");
		}
		catch (EntityNotFoundException e) 
		{
			resp.getWriter().println("Update record Failed");
			resp.sendError(resp.SC_NOT_FOUND, "Update record Failed " + str[1] + " : " +str[2]);
		}

	}

	/*
	 * Gets an entity or list of entities from the datastore based on URI
	 * Error: if entity not found
	 * Success: if entity found and outputs XML response
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String path_info = req.getPathInfo();
		String str[]=path_info.split("/");
		
		if(str.length <= 2) {
			if (!isValidType(str[1])) {
				resp.sendError(resp.SC_NOT_FOUND, str[1]+" Unknown type ");
				return;
			}
			
			Query q = new Query(str[1]); 
			PreparedQuery pq = datastore.prepare(q);
			List<Entity> es = pq.asList(FetchOptions.Builder.withDefaults());
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
			xml = xml + "<" + str[1] + "List>\n";
			for (Entity e : es) {
				xml = xml += entity2XML(e, false);
			}
			xml = xml + "</" + str[1] + "List>";
			resp.setContentType("text/xml");
			resp.getWriter().println(xml);
			resp.setStatus(resp.SC_OK);
			return;
		}
		if (!isValidType(str[1])) {
			resp.sendError(resp.SC_NOT_FOUND, str[1]+" Unknown type ");
			return;
		}
		Key k1 = KeyFactory.createKey(str[1],Integer.parseInt(str[2]));
		try {
			Entity e= datastore.get(k1);
			resp.setContentType("text/xml");
			resp.getWriter().println(entity2XML(e, true));
			resp.setStatus(resp.SC_OK);
		}
		catch (EntityNotFoundException e) 
		{
			e.printStackTrace();
			resp.getWriter().println(str[1] + " : " + str[2] + " record not found");
			resp.sendError(resp.SC_NOT_FOUND, str[1]+" record not found ");
		}
	}

	/*
	 * Deletes an entity from the datastore based on the id in the request
	 * Error: if entity not found
	 * Success: if entity found
	 */
	public void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String path_info = req.getPathInfo();
		String str[]=path_info.split("/");
		resp.setContentType("text/plain");

		if(str.length < 2 || !isValidType(str[1])) {
			resp.sendError(resp.SC_NOT_FOUND, str[1]+" Invalid req format: " );
		}
		Key k1=KeyFactory.createKey(str[1],Integer.parseInt(str[2]));
		try {
			Entity e = datastore.get(k1);
			datastore.delete(k1);
			resp.setStatus(resp.SC_OK);
			resp.getWriter().println("Delete record successful");
		}
		catch (EntityNotFoundException e) 
		{
			e.printStackTrace();
			resp.getWriter().println(str[1] + " : " + str[2] + " record not found");
			resp.sendError(resp.SC_NOT_FOUND, str[1]+" record not found : ");
		}
	}

	//--------------------UTIL Functions--------------------
	/*
	 * Adds entity and their properties to datastore
	 * 
	 */
	public static void AddEntity(String entityname,Map<String, Object> xmlmap){

		Entity en = new Entity(entityname, (int) xmlmap.get("id"));
		for( Entry<String,Object> e :xmlmap.entrySet())
		{
			en.setProperty(e.getKey(), e.getValue());
		}
		datastore.put(en);
		System.out.println("employee created " + en.toString());
	}

	/*
	 * converts key,value pair in Hashmap to XML
	 * @returns xml content as string
	 */

	public static String entity2XML(Entity e, boolean header) {
		String kind=e.getKind();

		String XML = "";
		if (header) {
			XML="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		}
		XML=XML+"\n<"+kind+">";
		String key = null;
		Object value = null;
		Map<String, Object> props = e.getProperties();

		for (Entry<String, Object> entry : props.entrySet()) {

			key=entry.getKey();
			value= entry.getValue();

			XML=XML+"\n<"+key+">" + value + "</"+key+">";
		}
		XML=XML+"\n</"+kind+">";
		return XML;
	}

	/*
	 * @returns True if object type is employee || project
	 */
	public static boolean isValidType(String s) {
		return (s.equals("employee") || s.equals("project"));
	}

}

