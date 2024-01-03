<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>       
  		<%
  		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionbank", "root", "root");
	        
	        
	        Statement st = conn.createStatement();
	        String query = "select * from ead";
	        ResultSet rs =st.executeQuery(query);
	        while (rs.next()) {
  			
  		
  		%>
  		<p> <%=rs.getInt("question_id") %></p>
  		<p> <%=rs.getString("question") %></p>
  		<p> <%=rs.getString("optionA") %></p>
		<p>  <%=rs.getString("optionB") %></p>
		<p>  <%=rs.getString("optionC") %></p>
		<p>  <%=rs.getString("optionD") %></p>
		<p>  <%=rs.getString("answer") %></p>
		<h6><a href='Edit.jsp?id=<%=rs.getInt("question_id") %>'>edit</a></h6>
  		<h6> <a href='deleteurl?id=<%=rs.getInt("question_id") %> '>delete</a></h6>
		<%}
		
		
  		}catch (Exception e){
			
  			
  		}
  		%>
  		
  		
  			
             
</body>
</html>