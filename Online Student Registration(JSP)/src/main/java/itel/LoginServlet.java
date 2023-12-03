package itel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final String url ="jdbc:mysql://localhost:3306/user";
			private static final String USER = "root";
			private static final String PASSWORD = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				
				String email = request.getParameter("email");
				String password = request.getParameter("password");
	
			 	
			 	
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn =

				DriverManager.getConnection(
				url, USER, PASSWORD);
				String query = "select * from users where email = ? AND password = ?";

				PreparedStatement pstmt =

				conn.prepareStatement(query);

				pstmt.setString(1, email);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					String name=rs.getString("name");
					HttpSession session =request.getSession();
				 	session.setAttribute("name", name);
				//authentication successful
				conn.close();
				response.sendRedirect("welcome.jsp");
				}else {
				//authentication failed
				conn.close();
				response.sendRedirect("login.jsp");
				}

				}catch(Exception  e) {
				e.printStackTrace();
				}
					
				
	}}
	 

