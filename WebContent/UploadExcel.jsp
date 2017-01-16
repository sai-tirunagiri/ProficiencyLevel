<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%
	ResultSet resultset = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>






	<form action="UploadServlet" method="post" enctype="multipart/form-data">


		<%
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qicmetrics", "root","");
				Statement statement = connection.createStatement();
				resultset = statement.executeQuery("select * from project_metadata");
		%>

		<center>
			<h3>File Upload:</h3>
			
			<h3>Select Project</h3>
			<label for="Project"></label> <select name="project" id="project">
				<%
					while (resultset.next()) {
				%>
				<option><%=resultset.getString(2)%></option>
				<%
					}
				%>
			</select> 
				<h3>Select month:</h3>
				<label for="Month"></label> <select name="month" id="month">
				<option value="Jan" selected>Jan</option>
				<option value="Feb">Feb</option>
				<option value="Mar">Mar</option>
				<option value="Apr">Apr</option>
			</select> <br /> <br /> <br /> 
				<h3>Select year:</h3>
				<label for="Year"></label> <select
				name="year" id="year">
				<option value="2016" selected>2016</option>
				<option value="2017">2017</option>
			</select> <br /> <br /> <br /> 
			<h3>Select a file to upload:</h3>
			<input type="file" name="file" /><br /> <br />
			<input type="reset" value="cancel">
			 <input type="submit" value="Submit"/>


		</center>

		<%
			//**Should I input the codes here?**
			} catch (Exception e) {
				out.println("wrong entry" + e);
			}
		%>





		<!-- 			 		 <label for="Project"></label> -->

		<!--              			 <select name="project" id="project" onchange="setAction(this.value)"> -->
		<!--               			 	 <option value="ARRIS" selected>ARRIS</option> -->
		<!--            					 <option value="MMI">MMI</option> -->
		<!--            					 <option value="MSI">MSI</option> -->
		<!--            					 <option value="Wm">Wm</option> -->
		<!--               			 </select> <br /><br /><br/> -->

		<!-- 		<label for="Month"></label> <select name="month" id="month"> -->
		<!-- 			<option value="Jan" selected>Jan</option> -->
		<!-- 			<option value="Feb">Feb</option> -->
		<!-- 			<option value="Mar">Mar</option> -->
		<!-- 			<option value="Apr">Apr</option> -->
		<!-- 		</select> <br /> -->
		<!-- 		<br /> -->
		<!-- 		<br /> <label for="Year"></label> <select name="year" id="year"> -->
		<!-- 			<option value="2016" selected>2016</option> -->
		<!-- 			<option value="2017">2017</option> -->
		<!-- 		</select> <br /> -->
		<!-- 		<br /> -->
		<!-- 		<br /> <input type="file" name="file" /><br /> <br /> <input -->
		<!-- 			type="reset" value="cancel"> <input type="submit" -->
		<!-- 			value="Submit" /> -->
	</form>



</body>
</html>