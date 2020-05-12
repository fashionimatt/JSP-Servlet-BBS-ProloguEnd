package com.pe.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.pe.web.entity.Notice;

public class NoticeService {
	
	
	public List<Notice> getNoticeList(){
		return getNoticeList("title", "", 1);
	}
	
	public List<Notice> getNoticeList(int page){
		return getNoticeList("title", "", page);
	}
	
	public List<Notice> getNoticeList(String field, String query, int page){
	/*field에는 title,author이 들어감! */
		
		List<Notice> list = new ArrayList<>();
		
		String sql = "SELECT * FROM (" + 
				"    SELECT ROWNUM NUM, N.* " + 
				"    FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N" + 
				"    )" + 
				" WHERE NUM BETWEEN ? AND ?";

		//10페이지씩 출력할 것이므로 시작되는 페이지는 1,11,21,31....
		//그러므로 an = 1+(page-1)*10
		//끝나는 페이지는 10,20,30,40....
		//page*10
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+query+"%");
				pstmt.setInt(2, 1+(page-1)*10);
				pstmt.setInt(3, page*10);
			ResultSet rs = pstmt.executeQuery();
			
			
			
			while(rs.next()){
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int cnt = rs.getInt("cnt");
				String content = rs.getString("content");
				String files = rs.getString("files");
				Timestamp regdate = rs.getTimestamp("regdate");
				Notice notice = new Notice(
						id,
						title,
						author,
						cnt,
						content,
						files,
						regdate
						);
				list.add(notice);
			};
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getNoticeCount(){
	
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query){
		
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM (" + 
				"    SELECT ROWNUM NUM, N.* " + 
				"    FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N" + 
				"    )";
		
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+query+"%");
			ResultSet rs = pstmt.executeQuery();
			
			count = rs.getInt("count");
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public Notice getNotice(int id) {
		
		Notice notice = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			
			String countsql = "UPDATE NOTICE SET CNT = CNT+1 WHERE ID=?";
			PreparedStatement pstmt = conn.prepareStatement(countsql);

				pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			String sql = "SELECT * FROM NOTICE WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			
				pstmt.setInt(1, id);
				
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				int db_id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int cnt = rs.getInt("cnt");
				String content = rs.getString("content");
				String files = rs.getString("files");
				Timestamp regdate = rs.getTimestamp("regdate");
				notice = new Notice(
						id,
						title,
						author,
						cnt,
						content,
						files,
						regdate
						);
			};
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	public Notice getNextNotice(int id) {

		Notice notice = null;
		
		String sql = "SELECT * FROM NOTICE WHERE ID = (" + 
				"SELECT ID FROM NOTICE " + 
				"WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID=?) " + 
				"AND ROWNUM = 1" + 
				")";
		
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
				pstmt.setInt(1, id);
				
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				int db_id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int cnt = rs.getInt("cnt");
				String content = rs.getString("content");
				String files = rs.getString("files");
				Timestamp regdate = rs.getTimestamp("regdate");
				notice = new Notice(
						id,
						title,
						author,
						cnt,
						content,
						files,
						regdate
						);
			};
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	public Notice getPrevNotice(int id) {

		Notice notice = null;
		
		String sql = "SELECT * FROM NOTICE WHERE ID = (" + 
				"SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC) " + 
				"WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID=?) " + 
				"AND ROWNUM = 1" + 
				")";
		
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
				pstmt.setInt(1, id);
				
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				int db_id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int cnt = rs.getInt("cnt");
				String content = rs.getString("content");
				String files = rs.getString("files");
				Timestamp regdate = rs.getTimestamp("regdate");
				notice = new Notice(
						id,
						title,
						author,
						cnt,
						content,
						files,
						regdate
						);
			};
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	//하나의 게시글을 저장하는 메소드 호출
	public void insertNotice(Notice notice) {
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		try {
			//쿼리 작성
			String sql = "insert into notice values (notice_seq.nextval,?,?,?,0,?,sysdate)";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, notice.getTitle());
				pstmt.setString(2, notice.getAuthor());
				pstmt.setString(3, notice.getContent());
				pstmt.setString(4, notice.getFiles());
			pstmt.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//조회수를 증가시키지 않는 하나의 게시글을 돌려받는 메소드 호출
	public Notice getUpdateNotice(int id) {

		Notice notice = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");

			String sql = "SELECT * FROM NOTICE WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			
				pstmt.setInt(1, id);
				
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				int db_id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int cnt = rs.getInt("cnt");
				String content = rs.getString("content");
				String files = rs.getString("files");
				Timestamp regdate = rs.getTimestamp("regdate");
				notice = new Notice(
						id,
						title,
						author,
						cnt,
						content,
						files,
						regdate
						);
			};
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	public void updateNotice(int id, String title, String content) {
		
		//DB연결
		String url = "jdbc:oracle:thin:@localhost:1521:harry";
		
		try {
			//쿼리 작성
			String sql = "update notice set title=?,content=? where id=?";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, id);
			pstmt.executeUpdate();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteNotice(int id) {
		//DB연결
			String url = "jdbc:oracle:thin:@localhost:1521:harry";
			
			try {
				//쿼리 작성
				String sql = "delete from notice where id=? ";
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(url, "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, id);
				pstmt.executeUpdate();
				conn.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
