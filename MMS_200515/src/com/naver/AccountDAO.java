package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "CA2";
	private final String PASSWORD = "ca2";
	
	
	public AccountDAO() {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//계좌이체 하는 것
	public void transfer(String sender, String receive, int money) {
		Connection conn = null;  //transaction 작업은  connection은 1개여야한다. 
		PreparedStatement pstmt1 = null; //주문지는 달라야한다
		PreparedStatement pstmt2 = null;
		
		String sql1 = "update account set balance = balance - ? where name = ?";
		String sql2 = "update account set balance = balance + ? where name = ?";
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//autocommit 해제
			conn.setAutoCommit(false);
					
			
			pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setInt(1, money);  //인출한다
			pstmt1.setString(2, sender);  //보내는 사람한테서
			
			pstmt1.executeUpdate();
		
			pstmt1.close();
			
			System.out.println(4/0); //정전 상황이라 가정
			
			//입금되는 형태
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, money);
			pstmt2.setString(2, receive);
			
			pstmt2.executeUpdate();
			
			isOk = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback(); //jdbc는 autocommit ->수동commit으로 바꿔주기! 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				if (pstmt2 != null) {
					pstmt2.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}
