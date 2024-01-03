<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Question</title>
</head>
<body>
    <h1>Edit Question</h1>
    <%

    	try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionbank", "root", "root");
	        int id = Integer.parseInt(request.getParameter("id"));
	    	System.out.println(id);
	        
	        
	        String query = "select  question ,optionA ,optionB ,optionC ,optionD,answer from ead where question_id  = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
	        rs.next();

	    
		

		%>

    <form action="editQuestion" method="post">
        <input type="hidden" name="id" value="<%=id%>">

        <label for="question">Question:</label>
        <input type="text" name="question" value="<%= rs.getString("question") %>"><br>

        <label for="optionA">Option A:</label>
        <input type="text" name="optionA" value="<%= rs.getString("optionA") %>" ><br>

        <label for="optionB">Option B:</label>
        <input type="text" name="optionB"  value="<%= rs.getString("optionB") %>"><br>

        <label for="optionC">Option C:</label>
        <input type="text" name="optionC" value="<%= rs.getString("optionC") %>" ><br>

        <label for="optionD">Option D:</label>
        <input type="text" name="optionD"  value="<%= rs.getString("optionD") %>"><br>

        <label for="answer">Answer:</label>
        <input type="text" name="answer"  value="<%= rs.getString("answer") %>"><br>

        <input type="submit" value="Edit">
        <%
      
		
		
  		}catch (Exception e){
  			 e.printStackTrace();
			
  			
  		}
  		%>
    </form>

</body>
</html>
