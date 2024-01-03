package questionBank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createQuestion")
public class createQuestion extends HttpServlet {

	 private static final String DB_URL ="jdbc:mysql://localhost:3306/questionbank";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createQuestion() {
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
	
//		doGet(request, response);
		String question =request.getParameter("question");
		String optionA =request.getParameter("optionA");
		String optionB =request.getParameter("optionB");
		String optionC =request.getParameter("optionC");
		String optionD =request.getParameter("optionD");
		String answer=request.getParameter("answer");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn =

			DriverManager.getConnection(
			DB_URL,
			DB_USER,
			DB_PASSWORD);
			String query ="insert into ead( question, optionA , optionB ,optionC , optionD ,answer) values(?,?,?,?,?,?)";
			
			PreparedStatement pstmt =conn.prepareStatement(query);
			
			pstmt.setString (1,question);
			pstmt.setString(2,optionA);
			pstmt.setString(3,optionB);
			pstmt.setString(4,optionC);
			pstmt.setString(5,optionD);
			pstmt.setString(6,answer);
			 
			pstmt.executeUpdate();
			conn.close();
			
		
		    response.sendRedirect("confirmation.jsp");
	        
		}catch(Exception e)

           {

        e.printStackTrace();
        }
	}

}
