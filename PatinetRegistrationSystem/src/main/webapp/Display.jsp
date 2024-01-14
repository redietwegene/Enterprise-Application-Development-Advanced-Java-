<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>patient infmations</title>
</head>
<body>
     <h1> <a href="PatientRegistration.jsp">create Patinet </a></h1>

 
  <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientdb", "root", "root");
            
            Statement st = conn.createStatement();
            String query = "select * from patients";
            ResultSet rs = st.executeQuery(query);

          
         
          
            while (rs.next()) {
        %>
        
        <h2 ><%= rs.getString("name") %> </h2>
        <p> <%= rs.getString("age") %> </p>
        <p> <%= rs.getString("gender") %></p>
        <p><%= rs.getString("email") %> </p>
        <p> <%= rs.getString("phone") %></p>
                <%
            
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging
        }
        %> 
        
        

</body>
</html>