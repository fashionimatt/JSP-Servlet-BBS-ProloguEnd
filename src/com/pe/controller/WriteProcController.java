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

@WebServlet("/notice/WriteController")
public class WriteProcController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Bean���� ������ �о����
		request.setCharacterEncoding("utf-8");
		
		NoticeBean notice = new NoticeBean();
		notice.setTitle(request.getParameter("title"));
		notice.setAuthor(request.getParameter("author"));
		notice.setContent(request.getParameter("content"));
		notice.setFiles(request.getParameter("files"));
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		response.sendRedirect("list");
	}
}
