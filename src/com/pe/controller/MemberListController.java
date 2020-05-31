package com.pe.controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.MemberBean;
import com.pe.service.MemberService;

@WebServlet("/Memberlist")
public class MemberListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB�� �����Ͽ� ȸ���� ��� ���� ��������
		MemberService service = new MemberService();
		Vector<MemberBean> vec = service.getAllMember();
		
		request.setAttribute("vec", vec);//���͸� jsp������ �ѱ�
		
		RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/view/membership/memberList.jsp");
		dis.forward(request, response);
	}
}
