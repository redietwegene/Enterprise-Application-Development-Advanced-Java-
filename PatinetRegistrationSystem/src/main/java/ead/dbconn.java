package ead;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dbconn
 */
@WebServlet("/dbconn")
public class dbconn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbconn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

//		try {
//			String driver = "com.mysql.cj.jdbc.Driver";
//			String url = "jdbc:mysql://localhost:3306/patientdb";
//			String username = "root"; 
//			String password = "root"; 
//			Class.forName(driver); 
//			Connection conn = DriverManager.getConnection(url,
//			username, password);
//			PrintWriter pw= response.getWriter();
//		
//			pw.println("connected successfully");			}catch (Exception e) {
//			e.printStackTrace();// TODO: handle exception
//			}
//		
//	}
//	
		  try {
	            Connection conn = getConnection();
	            PrintWriter pw = response.getWriter();
	            pw.println("Connected successfully");
	        } catch (Exception e) {
	            e.printStackTrace(response.getWriter());
	        }
	}
		  static Connection getConnection() throws Exception {
		        String driver = "com.mysql.cj.jdbc.Driver";
		        String url = "jdbc:mysql://localhost:3306/patientdb";
		        String username = "root";
		        String password = "root";
		        Class.forName(driver);
		        return DriverManager.getConnection(url, username, password);
		    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
