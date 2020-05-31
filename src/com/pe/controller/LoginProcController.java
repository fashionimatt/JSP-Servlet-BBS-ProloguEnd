package com.pe.controller;

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

import com.pe.service.MembershipService;

@WebServlet("/membership/LoginProc")
public class LoginProcController extends HttpServlet {
	
	private String email, password;
	
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
		
		MembershipService ms = new MembershipService();
		
		ms.loginMember(email, password, request, response);
		
	}
	
	
}
