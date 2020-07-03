package a;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;




public class InsertCommand implements Command{
	

	//필드영역  ->  대입안됨, 메소드 호출안됨(메소드 안, 생성자 안에서만 가능) 
	
	@Override
	public void execute(Scanner sc) {
		System.out.println("아이디를 입력하세요");
		String id =  sc.nextLine();
		
		System.out.println("이름을 입력하세요");
		String name = sc.next();
		sc.nextLine();
		
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		sc.nextLine();
		
		//insert
//		MemberDTO dto = new MemberDTO(id, name, age);
//		DB.db.add(dto);
		
		
		
		DB.db.add(new MemberDTO(id, name, age));
		
		
		
	}
	
}
