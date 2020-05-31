package com.pe.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pe.bean.NoticeBean;
import com.pe.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field_temp = request.getParameter("f");
		String query_temp = request.getParameter("q");
		String page_temp = request.getParameter("p");
		
		String field = "title";
		if(field_temp!=null && !field_temp.equals("")) {
			field = field_temp;
		}
		
		String query = "";
		if(query_temp!=null && !query_temp.equals("")) {
			query = query_temp;
		}
		
		int page = 1;
		if(page_temp!=null && !page_temp.equals("")) {
			page = Integer.parseInt(page_temp);
		}
		
		NoticeService service = new NoticeService();
		List<NoticeBean> list = service.getNoticeList(field, query, page);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp")
		.forward(request, response);
	}
	
	
	
}
