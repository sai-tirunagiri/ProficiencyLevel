package com.org.Dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.sql.Connection;


public class sqlDao {
			
	public boolean InsertSql(){
		try {
		
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qicmetrics", "root", "");
		
				java.sql.Statement st;
				
				st = con.createStatement();
				String sql = "INSERT INTO metrics "+"VALUES ('','','','Nov',2016,'Tridib','')";
			    st.executeUpdate(sql);
			    return true;
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
		}
	}
	
	public boolean RetrieveSql(){
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qicmetrics", "root", "");
			Statement st = null;
			
			st = con.createStatement();
		
		  String sql = "SELECT * FROM project_metadata where Project_Name=\"Arris\"";
	      ResultSet rs;
	      int project_id = 0;
	      String project_manager = null;
	      String manager_email;
	      String project_name;
	      int vertical_id = 0;
		  rs = st.executeQuery(sql);
		
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         project_id  = rs.getInt("Project_ID");
	         project_manager = rs.getString("Project_Manager");
	         manager_email = rs.getString("Project_Manager_Email");
	         project_name = rs.getString("Project_Name");
	         vertical_id = rs.getInt("Vertical_ID");
	         
	         //Display values
	         System.out.print("ID: " +project_id);
	         System.out.print(", Manager: " +project_manager);
	         System.out.print(", Mail: " +manager_email);
	         System.out.println(", Project: " +project_name);
	         System.out.println(", VerticalID: " + vertical_id);
	      }
	      rs.close();
	      
	     
			
			
			
//			st = con.createStatement();
//			String sql1 = "INSERT INTO metrics "+"VALUES ('',"+ project_id +",'','Nov',2016,'Tridib','')";
//		    st.executeUpdate(sql1);
	      
//	      Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/qicmetrics", "root", "");
	      
	     
	                
	           String sqlQuery = "INSERT INTO `metrics`(Submission_Month,Submission_Year,Submitted_By,Project_ID,Vertical_ID) VALUE ('November','2016','"+project_manager+"',"+project_id+","+vertical_id+");";
	           st = con.createStatement();
	           System.out.println("before Rs1");
	           int rs1 = st.executeUpdate(sqlQuery); 
	           System.out.println( "rs1 contains :" + rs1);
	           
	       
		    
	      
	      
		    return true;
	       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("did not insert");
			return false;
		}

	}
	
	
}
