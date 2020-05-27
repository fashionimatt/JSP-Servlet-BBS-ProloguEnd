package com.pe.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pe.web.entity.Member;

public class MembershipService {
	
	//새로운 회원을 만든다.
	public void insertMember(Member member) {
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		String sql = "insert into member values (member_seq.nextval,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
	public Vector<Member> getAllMember(){
		
		//회원정보를 담을 Vector 생성
		Vector<Member> vec = new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			//���� �غ�
			String sql = "select * from member order by accountnum";
			//���� ���� ��ü
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//���� ���� �� ��� ��������
			ResultSet rs = pstmt.executeQuery();
			//�ݺ��� ���鼭 ȸ�� ���� ����
			while(rs.next()) {
				Member member = new Member();
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
