package com.pe.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/membership/LoginProc")
public class LoginProcController extends HttpServlet {
	
	private String email, password;
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqLoginProc(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqLoginProc(request, response);
	}
	
	protected void reqLoginProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		String query = "select * from member where email = '" + email + "' and password = '" + password + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:harry","scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				while(rs.next()) {
					email = rs.getString("email");
					password = rs.getString("password");
				}
				
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("email", email);
				httpsession.setAttribute("password", password);
				request.getRequestDispatcher("LoginSuccess").forward(request, response);
				
			} else {
				request.getRequestDispatcher("LoginFail").forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
