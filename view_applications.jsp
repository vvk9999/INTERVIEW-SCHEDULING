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
PADDING-LEFT:9CM;
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
	<h2>Candidates Applied For Interview </h2>
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	
	</tr>
	<tr bgcolor="#A52A2A">
	<td><b>Reg id</b></td>
	<td><b>experience</b></td>
	<td><b>domain-1</b></td>
	<td><b>domain-2</b></td>
	<td><b>number</b></td>
	<td><b>click bellow</b></td>
	
	</tr>
	<%
	try{ 
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "v.venkat");
	st=conn.createStatement();
	rs = st.executeQuery("select * from applyjob");
	while(rs.next()){
	%>
	<tr bgcolor="#DEB887">
	<td><%=rs.getString(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getString(5) %></td>
	
	<td><form action="Hr_review.html">
	<input type="submit" value="conduct interview"></form></td>
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