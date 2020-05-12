package com.pe.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.web.entity.Notice;
import com.pe.web.service.NoticeService;

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
		
		//해당 게시글 번호를 읽어들여야함
		int id = Integer.parseInt(request.getParameter("id"));
		
		//DB에서 하나의 게시글에 대한 정보를 돌려받는 메소드 호출
		NoticeService service = new NoticeService();
		Notice notice = service.getUpdateNotice(id);
		
		//Request
		request.setAttribute("notice", notice);

		request.getRequestDispatcher("/WEB-INF/view/notice/update.jsp")
		.forward(request, response);
	}

}
