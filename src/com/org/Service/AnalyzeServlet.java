package com.org.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.org.Generic.ExcelToJsonConvertor;
import com.org.Util.JsonObjectToList;

/**
 * Servlet implementation class HomepageServlet
 */
public class AnalyzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyzeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String year = request.getParameter("year");
			System.out.println("year selected is :" + year );
			ExcelToJsonConvertor converter = new ExcelToJsonConvertor();
			JSONObject json = converter.getJson("D:/Updated.xlsx");
			
			
			
			String responses = request.getParameter("response");
			String resolutions = request.getParameter("resolution");
			
			
			JsonObjectToList JsonObjectToList = new JsonObjectToList();
			Map<String, Integer> map = 	JsonObjectToList.getMap(json, responses);
			
			
			
			List<Entry> entryList = new ArrayList<Entry>(map.entrySet());
			System.out.println("\n==> Size of Entry list: " + entryList.size());
			for (Entry temp : entryList) {
				
				System.out.println(temp);
			}
			
		
			
			System.out.println("entrylist contains :-" + entryList);
			 
			 String responseString = entryList.toString();
			 responseString = responseString.replaceAll("=", ",");
			 System.out.println(responseString);
			 
			 request.setAttribute("responseString", responseString);
			
//			System.out.println("map value in Analyse servlet is :-"+map);
//					
//
//			 //converting map into JsonObject.
//			 JSONObject newJson = new JSONObject(map);
//			 
//			 System.out.println("New json is :" + newJson);
//			 
//			 request.setAttribute("excelJson", newJson);

			
			 
			 
			 
			 	JsonObjectToList JsonObjectToList1 = new JsonObjectToList();
				Map<String, Integer> map1 = 	JsonObjectToList1.getMap(json, resolutions);
				
				List<Entry> entryList1 = new ArrayList<Entry>(map1.entrySet());
				System.out.println("\n==> Size of Entry list: " + entryList1.size());
				for (Entry temp1 : entryList1) {
					
					System.out.println(temp1);
				}
				
			
				
				System.out.println("entrylist contains :-" + entryList1);
				 
				 String resolutionString = entryList1.toString();
				 resolutionString = resolutionString.replaceAll("=", ",");
				 System.out.println(resolutionString);
				 
				 request.setAttribute("resolutionString", resolutionString);
				
//				//converting map into JsonObject.
//				 JSONObject newJson1 = new JSONObject(map1);
//			
//				 
//				 
//				 System.out.println("New json is :" + newJson1);
//				 
//				 request.setAttribute("response", newJson1);
				 
			 
			request.getRequestDispatcher("ExeclGraphGenerator.jsp").forward(request,response);
			 
			}
			catch(Exception e){
			
				e.printStackTrace();
			}
		
		
	}

}
