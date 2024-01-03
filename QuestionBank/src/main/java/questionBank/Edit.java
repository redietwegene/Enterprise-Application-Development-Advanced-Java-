package questionBank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/editQuestion")
public class Edit extends HttpServlet {
	private static final String query="update ead set question=?,optionA=?,"
			+ "optionB=?, optionC=? ,optionD=?, answer=?"
			+"where question_id =?";
	private static final long serialVersionUID = 1L;

	/**="
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		PrintWriter pw = response.getWriter();
		
		System.out.println("here");
		int id = Integer.parseInt(request.getParameter("id"));

		// Retrieve other form parameters
		String question = request.getParameter("question");
		String optionA = request.getParameter("optionA");
		String optionB = request.getParameter("optionB");
		String optionC = request.getParameter("optionC");
		String optionD = request.getParameter("optionD");
		String answer = request.getParameter("answer");
		System.out.println(id);
		System.out.println(question);
		
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
			}
		
		try {
			Connection conn =

					DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/questionbank",
					"root",
					"root");
					
		     PreparedStatement ps = conn.prepareStatement(query);
		 	
				ps.setString (1,question);
				ps.setString(2,optionA);
				ps.setString(3,optionB);
				ps.setString(4,optionC);
				ps.setString(5,optionD);
				ps.setString(6,answer);
				ps.setInt(7, id); 
				 
		    
		  
		     int count = ps.executeUpdate();
		     if(count == 1) {
		     pw.println("<h2>Record is edited .</h2>");
		    }else {
		    pw.println("<h2>Record not edieted.</h2>");
		    }
		    } catch (SQLException se) {
		    se.printStackTrace();
		    pw.println("<h1>" + se.getMessage() + "</h1>");
		    } catch (Exception e) {
		    e.printStackTrace();
		    pw.println("<h1>" + e.getMessage() + "</h1>");
		    
		    }
		response.sendRedirect("EADQcreatejsp.jsp");
		   
		    }
	
		
		
	}

