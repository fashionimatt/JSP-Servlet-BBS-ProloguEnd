package com.pe.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pe.web.entity.Member;

public class MembershipService {
	
	//회원 한 사람에 대한 정보를 저장하는 메소드
	public void insertMember(Member member) {
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		//쿼리 준비
		String sql = "insert into member values (member_seq.nextval,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			//쿼리 실행 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//?에 대입할 자료 입력
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			//쿼리 실행
			pstmt.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//모든 회원의 정보를 가져오는 메소드
	public Vector<Member> getAllMember(){
		
		//리턴타입 선언
		Vector<Member> vec = new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			//쿼리 준비
			String sql = "select * from member order by accountnum";
			//쿼리 실행 객체
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//쿼리 실행 후 결과 가져오기
			ResultSet rs = pstmt.executeQuery();
			//반복문 돌면서 회원 정보 저장
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
