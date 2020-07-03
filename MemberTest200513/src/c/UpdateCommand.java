package c;

import java.util.Scanner;

import com.naver.DB;
import com.naver.MemberDTO;

import kr.co.ca.Command;




public class UpdateCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {
		
		System.out.println("수정할 id를 입력하세요");
		String id = sc.nextLine();
		
		
		
		MemberDTO dto = new MemberDTO(id, null, -1);
		boolean isMember = DB.db.contains(dto);   
		//db의 generic = dto  -> contains(o) 의 o에 dto 만들어주기 //contains 대신 indexof 로 해도됨 
		
		int i = DB.db.indexOf(dto); //맞으면 index, 아니면 -1로 가지고온다. 
		
		switch (i) {
		case -1:
			System.out.println("회원이 아닙니다");
			break;

		default:
			System.out.println("이름을 입력하세요");
			String name = sc.nextLine();
			
			System.out.println("나이를 입력하세요");
			int age = sc.nextInt();
			sc.nextLine();
			
			//dto 값을 바꾼것
			dto.setName(name);
			dto.setAge(age);
			
			//db 바꾸는법 -회원원이 어디있는지확인			
			DB.db.set(i, dto);
			break;
		}
		
		
//		
//		if (i != -1) {
//			System.out.println("이름을 입력하세요");
//			String name = sc.nextLine();
//			
//			System.out.println("나이를 입력하세요");
//			int age = sc.nextInt();
//			sc.nextLine();
//			
//			//dto 값을 바꾼것
//			dto.setName(name);
//			dto.setAge(age);
//			
//			//db 바꾸는법 -회원원이 어디있는지확인			
//			DB.db.set(i, dto);
//			
//		} else {
//			System.out.println("회원이 아닙니다.");
//		}
//		
		
//		
//		if (isMember) { //isMember = true 이렇게써도됨
//			System.out.println("이름을 입력하세요");
//			String name = sc.nextLine();
//			
//			System.out.println("나이를 입력하세요");
//			int age = sc.nextInt();
//			sc.nextLine();
//			
//			//dto 값을 바꾼것
//			dto.setName(name);
//			dto.setAge(age);
//			
//			//db 바꾸는법 -회원원이 어디있는지확인
//			int idx = DB.db.indexOf(dto);
//			DB.db.set(idx, dto);  // idx 인덱스로 가진것을 dto로 수정하세요!!  (어제 set 배울때  contains(회원여부확인) or indexof(만약 회원이 없으면 -1 )로 수정)
//			
//		} else {
//			System.out.println("회원이 아닙니다.");
//		}
//		
		
	}
}
