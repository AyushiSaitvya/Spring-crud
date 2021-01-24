package com.luv2code.testdb;

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
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user="springstudent";
		String pass="springstudent";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			PrintWriter outPrintWriter=response.getWriter();
			System.out.println("jdbc "+jdbcUrl);
			
			Class.forName(driver);
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("DONE !");
			
			myConn.close();
			
			
		}
		catch(Exception exc){
			exc.printStackTrace();
			throw new ServletException();
			
		}
	}

}
