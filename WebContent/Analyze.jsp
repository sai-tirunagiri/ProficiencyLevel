<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		
		
		 <form action="AnalyzeServlet" method="post">
      <table width="408" border="0">
        <tr>
          <td width="402"><h3 align="center">Enter Year:</h3>
            <h3 align="center">
              <label for="Year"></label>
              <select name="year" size="1" id="year">
                <option value="2016" selected>2016</option>
                <option value="2017">2017</option>
              </select>
              <br/>
              
            <h3>Select Response for severity:</h3>
				<label for="Response"></label> <select name="response">
				<option value="SLA_Adherence_for_Response_Time_%_-_Critical_(Severity_1)_" selected>Severity1</option>
				<option value="SLA_Adherence_for_Response_Time_%_-_High_(Severity_2)">Severity2</option>
				<option value="SLA_Adherence_for_Response_Time_%_-_Medium_(Severity_3)">Severity3</option>
			</select> <br /> <br /> <br /> 
            </h3>
            
             <h3>Select Resolution for severity:</h3>
				<label for="Resolution"></label> <select name="resolution">
				<option value="SLA_Adherence_for_Resolution_Time_%_-_Critical_(Severity_1)" selected>Severity1</option>
				<option value="SLA_Adherence_for_Resolution_Time_%_-_High_(Severity_2)">Severity2</option>
				<option value="SLA_Adherence_for_Resolution_Time_%_-_Medium_(Severity_3)">Severity3</option>
			</select> <br /> <br /> <br /> 
            </h3>
            
            <h3 align="center"><strong></strong>
              <input type="submit" name="AddYear" id="AddYear" value="Add">
          </h3></td>
        </tr>
      </table>
      
      
      
      
      
</form>
		
		
		
</body>
</html>