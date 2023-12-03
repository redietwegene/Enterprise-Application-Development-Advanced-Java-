package i.com;


import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/operation")
public class operation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public operation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String operation = request.getParameter("operation");

	        if ("add".equals(operation)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/addition");
	            dispatcher.forward(request, response);
	        } else if ("multi".equals(operation)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/multi");
	            dispatcher.forward(request, response);
	        }  else if ("sub".equals(operation)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/sub");
	            dispatcher.forward(request, response);
	        }  else if ("divid".equals(operation)) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/divid");
	            dispatcher.forward(request, response);
	        } else {
	            response.getWriter().println("Invalid operation");
	}

}
	}