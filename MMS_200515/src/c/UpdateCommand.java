package c;

import java.util.Scanner;

import com.naver.MemberDAO;
import com.naver.MemberDTO;

import kr.co.ca.Command;

public class UpdateCommand implements Command {
	@Override
	public void execute(Scanner sc) {
		System.out.println("수정할 아이디 입력");
		String id = sc.nextLine();
		
		System.out.println("수정할 이름 입력");
		String name = sc.nextLine();
		
		System.out.println("수정할 나이 입력");
		int age = sc.nextInt();
		sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, name, age);
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
		
	}
}
