package com.te.qa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONDataReader {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser jsonparser = new JSONParser();
		String Projectpath = System.getProperty("user.dir");
		FileReader reader = new FileReader(Projectpath+"\\JSON_TestData\\TestData.json");
		Object obj = jsonparser.parse(reader);
		JSONObject jsonobj = (JSONObject)obj;
		String fname = (String) jsonobj.get("firstname");
		String lname = (String) jsonobj.get("lastname");
		
		System.out.println(fname);
		System.out.println(lname);
		
	}
}
