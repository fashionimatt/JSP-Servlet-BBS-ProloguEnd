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
 * Servlet implementation class DeleteController
 */
@WebServlet("/notice/delete")
public class DeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������ �۹�ȣ�� �Է�
		int id = Integer.parseInt(request.getParameter("id"));
		
		//DB�� �����Ͽ� �ϳ��� �Խñ��� �ҷ����� �޼ҵ�
		NoticeService service = new NoticeService();
		
		service.deleteNotice(id);
		
		response.sendRedirect("list");
		
	}

}
