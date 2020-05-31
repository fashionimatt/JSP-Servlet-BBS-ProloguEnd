package com.pe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.NoticeBean;
import com.pe.service.NoticeService;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/notice/update")
public class UpdateController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�ش� �Խñ� ��ȣ�� �о�鿩����
		int id = Integer.parseInt(request.getParameter("id"));
		
		//DB���� �ϳ��� �Խñۿ� ���� ������ �����޴� �޼ҵ� ȣ��
		NoticeService service = new NoticeService();
		NoticeBean notice = service.getUpdateNotice(id);
		
		//Request
		request.setAttribute("notice", notice);

		request.getRequestDispatcher("/WEB-INF/view/notice/update.jsp")
		.forward(request, response);
	}

}
