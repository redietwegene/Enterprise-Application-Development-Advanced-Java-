package itel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	       private static final String DB_URL ="jdbc:mysql://localhost:3306/user";
			private static final String DB_USER = "root";
			private static final String DB_PASSWORD = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
    }
	
	
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn =

			DriverManager.getConnection(
			DB_URL,
			DB_USER,
			DB_PASSWORD);
			String query = "insert into users(name, email, password)values(?,?,?)";
			PreparedStatement pstmt =conn.prepareStatement(query);

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
			conn.close();

			response.sendRedirect("confirmation.jsp");
			}catch(Exception e)

               {

            e.printStackTrace();
		
		

       

	}
		


		
//		User user = new User();
//		user.setName(name);
//		user.setEmail(email);
//		user.setPassword(password);
//		// Store the user (you can use a simple ArrayList here or a database)
//		// For demonstration purposes, let's assume adding to a list
//		List<User> userList = new ArrayList<>();
//		userList.add(user);
//		// Redirect to confirmation page
//		response.sendRedirect("confirmation.jsp");
//		doGet(request, response);
	}

}


