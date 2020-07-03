package b;

import java.util.List;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;



public class SelectCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {  //scanner sc 필요없으나 지우면 안됨 
		
		List<MemberDTO> list = DB.db;  // 그냥 보여준것. list 대신 DB.db만 써도 된다. 
		
		
		for (int i =0; i < list.size(); i ++) {
			
			MemberDTO dto = list.get(i);  // 사과상자에서 사과 하나 가져옴 
			
			//MemberDTO dto1 = new MemberDTO();  /////  x
			//dto1 = list.get(i);  /////  x
			
			System.out.println(dto);  //dto.toString
			
			//만약 dto 사용하고 싶으면 dto.getid 등등 하기~ 
//			System.out.println(dto.getId());
//			System.out.println(dto.getName());
		}  
		
		
		
	}
}
