package com.pe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.dao.Member;
import com.pe.service.MembershipService;

@WebServlet("/membership/JoinProcController")
public class JoinProcController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqJoin(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqJoin(request, response);
	}
	
	protected void reqJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�ѱ� ���� ���� ó��
		request.setCharacterEncoding("utf-8");
		
		Member member = new Member();
		//����ڷκ��� �Ѿ�� ȸ������ ������ bean�� ��� ���� 
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPassword(request.getParameter("password"));
		member.setGender(request.getParameter("gender"));
		
		//�����ͺ��̽� ��ü ���� �� ����
		MembershipService service = new MembershipService();
		service.insertMember(member);

		response.sendRedirect("JoinSuccess");
	}
	
	
}
