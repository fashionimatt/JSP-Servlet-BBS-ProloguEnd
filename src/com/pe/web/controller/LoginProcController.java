package com.pe.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/membership/LoginProcController")
public class LoginProcController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqLoginProc(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqLoginProc(request, response);
	}
	
	protected void reqLoginProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
}
