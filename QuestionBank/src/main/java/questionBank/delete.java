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
 * Servlet implementation class delete
 */
@WebServlet("/deleteurl")
public class delete extends HttpServlet {
	private static final String query = "Delete from ead where question_id=?";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delete() {
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
		PrintWriter pw = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}

		try {
			Connection conn =

					DriverManager.getConnection("jdbc:mysql://localhost:3306/questionbank", "root", "root");

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count == 1) {
				pw.println("<h2>Record is deletedsuccessfully.</h2>");
			} else {
				pw.println("<h2>Record not deleted.</h2>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
