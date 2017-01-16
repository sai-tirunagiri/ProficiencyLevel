package com.org.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectToList {
		public Map<String,Integer> getMap(JSONObject json , String data){
			List<String> List1 =null;
			List<String> List2 = null;
			
			
			Iterator<String> keysList = null;
			String parametersList = null;
			String string2 = null;
			JSONArray Array;
			try {
					Array = json.getJSONArray("rows");
			
					//to extract Parameters values from JSONArray 
					JSONObject Array1 = Array.getJSONObject(1);
					parametersList = Array1.get("Parameters").toString();
					String replace2 = parametersList.replace("[","");
			          System.out.println(replace2);
			          String String2 = replace2.replace("]","");
			          System.out.println(String2);
					List1 = new ArrayList<String>(Arrays.asList(String2.split(",")));
					System.out.println( " list 1 contains :" + parametersList);
					//modify = "{Month:["+List1+"]}";
					
					//This will return all the keys
					for(int i=0;i<Array.length();i++){
						//System.out.println("Object "+i+"-"+Array.getJSONObject(i));
						JSONObject sev1Object = Array.getJSONObject(i);
						keysList = sev1Object.keys();
						
						while(keysList.hasNext()){
						
						if(keysList.next().contains(data)){
							
									//to extract data of dynamic jsonArrays
									
									System.out.println(sev1Object.get(data).toString());
									string2 = sev1Object.get(data).toString();
									String replace = string2.replace("[","");
							        System.out.println(replace);
							        String replace1 = replace.replace("]","");
							        System.out.println(replace1);
							        List2 = new ArrayList<String>(Arrays.asList(replace1.split(",")));
									System.out.println("list 2 after splitting is : " + List2);
									
									
					          
									for (int k=0;k < List2.size();k++)
									{
									 
									  if(List2.get(k).equals("\"N/A\"")){
										  List2.set(k, "0");
										  System.out.println("Value replaced from N/A to :" + List2.get(k));
										 
									  }
									}
						
					   System.out.println("KeyFound");
								
					  }
				      else{
							System.out.println("Not found!");
	   			      }
							  
					}
							
							
					}
					
				System.out.println("list 2 contains : "+List2);
				
				//to remove the first key-value pair (PARAMETERS AND data coming from front end).
				List1.remove(0);
				List2.remove(0);

		         List<Integer> l=new ArrayList<Integer>();
		         for(String s : List2){
					 l.add(Integer.valueOf(s));
					
				 }
			 

		         System.out.println("New list with integer = " + l);
			
				//Inducing two lists into a map<String,Integer>
				LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();  // ordered
	
				    for (int k=0; k<List2.size(); k++) {
				      map.put(List1.get(k), l.get(k));    // is there a clearer way?
				    }
				   //map.remove(List1.get(0));
				 System.out.println("map data :" +map);
			
			
				 return map;
		} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
						
		}
}

