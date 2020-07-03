package a;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class InsertCommand implements Command{
	@Override
	public void execute(Scanner sc) {
		System.out.println("아이디를 입력하세요");
		String id =  sc.nextLine();
		
		System.out.println("이름을 입력하세요");
		String name =  sc.nextLine();
		
		System.out.println("나이를 입력하세요");
		String sAGe = sc.nextLine();  //Wrapper Class 이용하기
		int age = Integer.parseInt(sAGe);  //jsp sevlet 대비해서 이렇게~~ 
		
		MemberDTO dto = new MemberDTO(id, name, age);
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
		
	}
}
