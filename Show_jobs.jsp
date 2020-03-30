<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-color:#ADEFFF;
}
H1
{
COLOR:BLUE;
ALIGN:CENTER;
PADDING-LEFT:5CM;
}
h2
{
COLOR:red;
ALIGN:CENTER;
PADDING-LEFT:12CM;
}
</style>
</head>
<body>
	<%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
	<%
	
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	%>
	<H1>INTERVIEW SCHEDULING MANAGEMENT</H1>
	<h2>Latest Job Notifications </h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	
	</tr>
	<tr bgcolor="#A52A2A">
	
	<td><b>Domain</b></td>
	<td><b>vacancies</b></td>
	<td><b>last date for applying</b></td>
	<td><b>Priority</b></td>
	<td><b>Experience</b></td>
	<td><b>Click bellow</b></td>
	</tr>
	<%
	try{ 
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "v.venkat");
	st=conn.createStatement();
	rs = st.executeQuery("select * from applicant");
	while(rs.next()){
	%>
	<tr bgcolor="#DEB887">
	
	
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getString(5) %></td>
	<td><%=rs.getString(6) %></td>
	<td><%=rs.getString(7) %></td>
	
	<td><form action="details_job.html">
	<input type="submit" value="apply"></form></td>
	</tr>
	<% 
	}
	
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	</table>

</body>
</html>