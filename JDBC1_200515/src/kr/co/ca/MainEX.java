package kr.co.ca;

import com.naver.MemberDTO;
import com.naver.TestDAO;

public class MainEX {
	public static void main(String[] args) {
		TestDAO dao = new TestDAO();  //마름모 만듦
			
		//dao.insert(new MemberDTO());		
		//dao.selectAll();		
		//dao.update(new MemberDTO());
		
		MemberDTO dto = new MemberDTO("m001", "kim", 1);
		dao.insert(dto);
	}
}
