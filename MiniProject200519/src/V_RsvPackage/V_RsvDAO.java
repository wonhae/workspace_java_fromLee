package V_RsvPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class V_RsvDAO {
private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "CA2";
	private final String PASSWORD = "ca2";
	
	public V_RsvDAO() {
		try {
			Class.forName(DRIVERNAME);
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			System.out.println("driver loading success");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//delect 
	public void delect(String rsvId) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql ="delect from V_rsv where rsvId=?";
				try {
					
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					pstmt =conn.prepareStatement(sql);
					pstmt.setString(1, rsvId);
					pstmt.executeUpdate();
					
					//카모
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}finally {
					try {
						if (pstmt != null) {
							pstmt.close();
						}
						if (conn != null) {
							conn.close();
						}
						
					} catch (Exception e2) {
						e2.printStackTrace();
						// TODO: handle exception
					}
				}
		
	}
	
	///update
	public void update(V_RsvDTO dto) {
		
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql ="update V_rsv set customerId=?,customerName=?,movieId=?,movieTitle=?,theaterId=?,theaterName=?,rsvDay=?,rsvTime=?m,rsvNum=?,rsvPaymentMethod=?,rsvTotal=? where rsvId=?";
		 try {
			 conn =DriverManager.getConnection(URL, USERNAME, PASSWORD);
			 pstmt =conn.prepareStatement(sql);
			 pstmt.setString(1, dto.getCustomerId());
			 pstmt.setString(2, dto.getCustomerName());
			 pstmt.setString(3, dto.getMovieId());
			 pstmt.setString(4, dto.getMovieTitle());
			 pstmt.setString(5, dto.getTheaterId());
			 pstmt.setString(6, dto.getTheaterName());
			 pstmt.setString(7, dto.getRsvDay());
			 pstmt.setString(8, dto.getRsvTime());
			 pstmt.setInt(9, dto.getRsvNum());
			 pstmt.setString(10, dto.getRsvPaymentMethod());
			 pstmt.setInt(11, dto.getRsvTotal());
			 pstmt.setString(12, dto.getRsvId());
			 pstmt.executeUpdate();
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		
	}
	
	
	//select 
	public List<V_RsvDTO> selectAll(){
		List<V_RsvDTO>  list = new ArrayList<V_RsvDTO>(); 
		
	Connection conn =null;
	PreparedStatement pstmt =null;
	String sql = "select from V_rsv";
	ResultSet rs =null;
	try {
		   conn =DriverManager.getConnection(URL, USERNAME, PASSWORD);
		   pstmt =conn.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   while (rs.next()) {
			   String customerId =rs.getString("customerId");
			   String customerName =rs.getString("customerName");
			   String movieId =rs.getString("movieId");
			   String movieTitle =rs.getString("movieTitle");
			   String theaterId =rs.getString("theaterId");
			   String theaterName =rs.getString("theaterName");
			   String rsvId =rs.getString("rsvId");
			   String rsvDay =rs.getString("rsvDay");
			   String rsvTime =rs.getString("rsvTime");
			   int rsvNum =rs.getInt("rsvNum");
			   String rsvPaymentMethod =rs.getString("rsvPaymentMethod");
			   int rsvTotal =rs.getInt("rsvTotal");
			   
			   V_RsvDTO dto =new V_RsvDTO(customerId, customerName, movieId, movieTitle, theaterId, theaterName, rsvId, rsvDay, rsvTime, rsvNum, rsvPaymentMethod, rsvTotal);
			
			   list.add(dto);
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
			// TODO: handle exception
		}
	}
	return list;
	}

	
	
	
	// insert
	public void insert(V_RsvDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into V_rsv (id,name,mvId,title,thId,thName,rsv_id,day,rsvTime,num,paymentMethod,total) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomerId());
			pstmt.setString(2, dto.getCustomerName());
			pstmt.setString(3, dto.getMovieId());
			pstmt.setString(3, dto.getMovieTitle());
			pstmt.setString(3, dto.getTheaterId());
			pstmt.setString(3, dto.getTheaterName());
			pstmt.setString(3, dto.getRsvId());
			pstmt.setString(3, dto.getRsvDay());
			pstmt.setString(3, dto.getRsvTime());
			pstmt.setInt(3, dto.getRsvNum());
			pstmt.setString(3, dto.getRsvPaymentMethod());
			pstmt.setInt(3, dto.getRsvTotal());
		
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)  pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
