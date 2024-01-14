package ead;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class patientRegistration
 */
@WebServlet("/patientRegistration")
public class patientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String name =request.getParameter("name");
		String age =request.getParameter("age");
		String gender =request.getParameter("gender");
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		
		
		try {
			 Connection conn = dbconn.getConnection();

		
			String query ="insert into patients( name, age, gender ,email , phone ) values(?,?,?,?,?)";
			
			PreparedStatement pstmt =conn.prepareStatement(query);
			
			pstmt.setString (1,name);
			pstmt.setString(2,age);
			pstmt.setString(3,gender);
			pstmt.setString(4,email);
			pstmt.setString(5,phone);
			
			 
			pstmt.executeUpdate();
			conn.close();
			
		
		    response.sendRedirect("Display.jsp");
	        
		}catch(Exception e)

           {

        e.printStackTrace();
        }
	}

	}


