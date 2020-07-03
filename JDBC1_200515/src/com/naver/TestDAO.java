package com.naver;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	
	// 1 ->마름모 만든다
	private final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver"; // 우클릭 CopyQualifiedName/ 소문자로 되있는건 패키지,
																			// UpperCamelCase : 클래스명
	// 2 ->3개 이용connection만든다.(길을만든다)
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // DataSourceExplorer>New
																		// Oracle>우클릭>properties>Driver
																		// Properties>connectionURL 복사 //localhost: 내pc																		
	private final String USERNAME = "ca2"; // 대문자로 적어도됨
	private final String PASSWORD = "ca2"; // 소문자로

	// 0.생성자
	public TestDAO() { // 생성자
		// (마름모)드라이브 만들기 = 메모리에 올라간다
		try {
			Class.forName(DRIVERNAME);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패"); // 고객한테 줄때는 에러 번호 적기 ->에러 메뉴얼있음
			e.printStackTrace(); // 고객들한테 줄때는 빼기
		}
	}
	
	//여기까지 CRUD 작업 끝... 
	//이런식으로는 하지 마세요. 아래처럼 컬럼당 하나씩 하세요. 
	public List<MemberDTO> selectWhat(String what, String value) {  //what 은 where절에 들어가는 컬럼  //statement 사용하여
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		Statement stmt = null;
		String sql = "";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			
			StringBuffer sb = new StringBuffer(); //sb 사용안하면
			sb.append("select * from TBL_member where ");
			sb.append(what);
			sb.append("='"); //숫자를 제외하고는 앞뒤로 작은따온표로 감싼다
			sb.append(value);
			sb.append("'");
			sql = sb.toString();
			
			rs = stmt.executeQuery(sql);  //preparedstatment 사용시에는 sql 안들어간다. 
			//위에는  pstmt vs. stmt 차이점
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				list.add(new MemberDTO(id, name, age));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt !=null) stmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	public MemberDTO selectById(String id) {  //id가 primarykey  ->하나만 반환하면 된다. 하나만...dto 하나... ////
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from TBL_member where id = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name =  rs.getString("name");
				int age = rs.getInt("age");
				dto = new MemberDTO(id, name, age);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			}
		}		
		return dto;
	}
	
	
	public List<MemberDTO> selectByName(String name) {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from TBL_member where name = ?";
		ResultSet rs = null;
		
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs =  pstmt.executeQuery();
			
			while (rs.next()) {
				int age = rs.getInt("age");
				String id = rs.getString("id");
				
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
				// list.add(new MemberDTO(id, name, age)); //이렇게 해도됨 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs == null) {
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
			}
		}
		return list;
	}
	
	

	// 나중에db작업시 문제: sql 몰라서
	// 4. delete (D) //여기까지 화살표(connection) 만든것
	public void delete(String id) {// id는 자바 프로그램에서 넘겨주는것
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM TABLE_member WEHRE id = ?";

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// 3. update (U)
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE TBL_member SET name = ?, age = ? WHERE id = ?"; // index ?의 index : 왼쪽에서부터 1
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결성공");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// 2. select (R)
	public List<MemberDTO> selectAll() { //반환형은 ResultSet으로 반환을 rs 해도 말은 되는데 이렇게 안쓴다. 
		
		List<MemberDTO> list = new ArrayList<MemberDTO>(); //db에서 넘겨주지 않는다면 상자가 존재할까요 안할까요? null or not? notnull(상자는 존재)
		
		Connection conn = null; // 절대 멤버 변수or static변수로 connection만들면 안된다. 반드시 지역변수(신뢰성 보장:thread 동기화의 안정화
								// 중요)로!!
		PreparedStatement pstmt = null;
		String sql = "SELECT id, name, age 나이 FROM TBL_member"; // ?없으니 적을필요 없음
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결성공");
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); // ResultSet 이것도 close 해줘야. 이거 거치면 rs =null일리는 없다. 
			//rs 데이터를 안넘겨받았어도 resultset 상자는 만들어진다. 
			
			//resultset =>list에 넣기 
			while (rs.next()) {
				String id =  rs.getString("id");  //"id"는 컬럼명처럼 보이지만 별칭. 컬럼명에 별칭 안붙이면 별칭 = 컬럼명
				int age = rs.getInt(2);  //index 넣어도 된다. id,name,age 순이므로
				String name = rs.getString("이름");
				
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	// 메서드
	// 1. insert작업 (C)
	public void insert(MemberDTO dto) { // 1. 화살표 만들고 제거

//		Connection conn = null;    //java.sql.Connection  //무조건 닫아줘야 한다!! conn != null(메모리 할당받았다)		
		// 기본구조 : connection선언하고 -> try - catch(e.prt) + finally(여기안에 try(if)
		// catch)(e2.prt) 기본구조 만들고 작업
//		try {
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		} finally { //try catch 먼저적기!  그안에 if문
//			try {
//				if(conn != null) {
//					conn.close(); //(conn = null일때 close: nullpointerException)
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}

		Connection conn = null; // interface로 클래스 안만든다. 유지보수위해 만든 부모 클래스로도 객체 안만든다.
		// 5-1. 주문서
		PreparedStatement pstmt = null;
		// 5-2.sql
		String sql = "INSERT INTO TBL_member(id, name,age) values (?,?,?)"; // ?의 index는 왼쪽에서 부터 1,2,3

		try {

			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("커넥션 연결성공");

			// 5-4. 커넥션 통해 넘겨받음: 빈종이에 원조김밥 참치김밥 인쇄하는 것 : 인쇄된 주문지 만든 것
			pstmt = conn.prepareStatement(sql);
			// 6. 세부내용 채우기(주문서에 쫄면2,김밥1이렇게입력) sql의 ? 채우기 (채우기 순서는 자유: 쫄면,김밥.일반적인것 위에서부터)
			pstmt.setString(1, dto.getId()); // 1 은 values(?첫번째? id)
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			// 7. 주문서 날린다.
			pstmt.executeUpdate();

		} catch (Exception e) {
			// System.out.println("커넥션 연결 실패 ");
			e.printStackTrace();
		} finally {
			try {
				// 5-3. 순서유의
				if (pstmt != null) {
					pstmt.close();
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
