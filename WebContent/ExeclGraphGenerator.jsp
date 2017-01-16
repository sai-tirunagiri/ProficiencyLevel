<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/chart1.js"></script>
<script type="text/javascript" src="js/JsonObjectSorting.js"></script>
<title>
Insert title here
</title>
<!-- This is for ajax -->
	 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 	
	 <script src="http://code.highcharts.com/highcharts.js"></script>
     <script src="https://code.highcharts.com/modules/exporting.js"></script>
</head>
<body>
			<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
			<div id="container1" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
	<script type="text/javascript">
		
		
		var response = ${responseString};
		var resolution = ${resolutionString};
		
		chart1(response,resolution);
		
		//JsonObjectSorting(json);
		
		
		
		
	</script>
</body>
</html>