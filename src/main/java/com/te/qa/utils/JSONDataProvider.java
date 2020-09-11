package com.te.qa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class JSONDataProvider {
	
	@DataProvider(name="dp")
	public void readJSON() throws IOException, ParseException {
		
		JSONParser jsonparser = new JSONParser();
		String Projectpath = System.getProperty("user.dir");
		FileReader reader = new FileReader(Projectpath+"\\JSON_TestData\\TestData.json");
		Object obj = jsonparser.parse(reader);
		JSONObject userloginsjsonobj = (JSONObject)obj;
		JSONArray userloginsArray = (JSONArray) userloginsjsonobj.get("uselogins");
		String arr[] = new String [userloginsArray.size()];
		for(int i=0;i<userloginsArray.size();i++) {
			 JSONObject users = (JSONObject)userloginsArray.get(i);
			String user = (String) users.get("username");
			String pwd = (String) users.get("password");
			
			arr[i] = user+","+pwd;
		}
		
	}
}
