package com.org.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.org.Dao.sqlDao;
import com.org.Factory.connectionFactory;





/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "E:/Java/TestFileUpload";
	public static Connection connection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String projectName = request.getParameter("project");
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			
			System.out.println("project name :" + projectName);
		
			System.out.println("time stamp");
			System.out.println("month :" + month);
			System.out.println("year :" + year);
			
			
			connectionFactory connect = new connectionFactory();
			
			try {
				
				Boolean connectToSql = connect.getConnection();
				if(connectToSql){
					System.out.println(" connection successful");
					sqlDao sqlDao = new sqlDao();
					boolean retrieveSuccessful = sqlDao.RetrieveSql();
					System.out.println("boolean value from retrieval is :" + retrieveSuccessful);
					if(retrieveSuccessful){
						
						boolean isMultipart = ServletFileUpload.isMultipartContent(request);

				        // process only if its multipart content
				        if (isMultipart) {
				                // Create a factory for disk-based file items
				                FileItemFactory factory = new DiskFileItemFactory();

				                // Create a new file upload handler
				                ServletFileUpload upload = new ServletFileUpload(factory);
				                try {
				                        // Parse the request
				                        List<FileItem> multiparts = upload.parseRequest(request);

				                        for (FileItem item : multiparts) {
				                          if (!item.isFormField()) {
				                             String name = new File(item.getName()).getName();
				                             item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
				                          }
				                        }
				                        System.out.println("Upload successful");
				                } 
				                catch (Exception e) 
				                {
				                  System.out.println("File upload failed");
				                }
				        }
					}
					
					
				}else{
					System.out.println(" connection not successful");
					
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
}
