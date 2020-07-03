import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReservationDAO {
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "CA2";
	private final String PASSWORD = "ca2";
	
	public ReservationDAO() {  //마름모 완성
		try {
			Class.forName(DRIVERNAME);
			System.out.println("driver loading success");
		} catch (ClassNotFoundException e) {
			System.out.println("driver loading fail");
			e.printStackTrace();
		}
	}
	
	public void rsvInsert(ReservationVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into tbl_member (id,name,age) values (?,?,?)";
		
		
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.get);
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getAge());
			
			pstmt.executeUpdate();
	}
	
	
	
	
}
