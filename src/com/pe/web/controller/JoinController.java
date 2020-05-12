package com.pe.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.web.entity.Member;
import com.pe.web.service.MembershipService;

@WebServlet("/membership/JoinController")
public class JoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqJoin(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqJoin(request, response);
	}
	
	protected void reqJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글 깨짐 방지 처리
		request.setCharacterEncoding("utf-8");
		
		Member member = new Member();
		//사용자로부터 넘어온 회원가입 정보를 bean에 담는 과정 
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPassword(request.getParameter("password"));
		member.setGender(request.getParameter("gender"));
		
		//데이터베이스 객체 선언 후 저장
		MembershipService service = new MembershipService();
		service.insertMember(member);

		response.sendRedirect("../index.jsp");
	}
	
	
}
