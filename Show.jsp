<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
	<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>
	
	</tr>
	<tr bgcolor="#A52A2A">
	<td><b>SNO</b></td>
	<td><b>NAME</b></td>
	<td><b>CONTACT</b></td>
	<td><b>Email</b></td>
	<td><b>EXPERIENCE</b></td>
	<td><b>TYPE</b></td>
	<td><b></b></td>
	</tr>
	<%
	try{ 
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "v.venkat");
	st=conn.createStatement();
	rs = st.executeQuery("select * from applicant");
	while(rs.next()){
	%>
	<tr bgcolor="#DEB887">
	<td><%=rs.getInt(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getInt(5) %></td>
	<td><%=rs.getString(6) %></td>
	<td><%=rs.getString(7) %></td>
	<td><%=rs.getString(8) %></td>
	<td><form action="Edits.html">
	<input type="submit" value="edit"></form></td>
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