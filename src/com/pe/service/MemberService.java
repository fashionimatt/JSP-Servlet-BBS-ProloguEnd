package com.pe.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pe.bean.MemberBean;

public class MemberService {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@localhost:1521:harry";
	
	//로그인 작업
	public void loginMember (String email, String password, HttpServletRequest request, HttpServletResponse response) {
		
		String query = "select * from member where email = '" + email + "' and password = '" + password + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				while(rs.next()) {
					email = rs.getString("email");
					password = rs.getString("password");
				}
				
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("email", email);
				httpsession.setAttribute("password", password);
				request.getRequestDispatcher("LoginSuccess").forward(request, response);
				
			} else {
				request.getRequestDispatcher("LoginFail").forward(request, response);
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//새로운 회원을 만든다.
	public void insertMember(MemberBean member) {
		
		
		String sql = "insert into member values (member_seq.nextval,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//회원 정보를 모두 불러온다.
	public Vector<MemberBean> getAllMember(){
		
		//회원정보를 담을 Vector 생성
		Vector<MemberBean> vec = new Vector();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			//���� �غ�
			String sql = "select * from member order by accountnum";
			//���� ���� ��ü
			pstmt = conn.prepareStatement(sql);
			//���� ���� �� ��� ��������
			rs = pstmt.executeQuery();
			//�ݺ��� ���鼭 ȸ�� ���� ����
			while(rs.next()) {
				MemberBean member = new MemberBean();
				member.setAccountnum(rs.getInt(1));
				member.setPassword(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setName(rs.getString(4));
				member.setGender(rs.getString(5));
				vec.add(member);
			}
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vec;
	}
	
}
