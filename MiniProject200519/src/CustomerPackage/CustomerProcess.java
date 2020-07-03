package CustomerPackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import Total.TotalCommand;

public class CustomerProcess implements TotalCommand {

	

	@Override
	public void execute(Scanner sc) {
		CustomerCommand[] commands = { new CustomerInsert(),new CustomerSelect(), new CustomerUpdate(),new CustomerDelete() };

		boolean istrue = true;
		int menu = -1;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(cal.getTime());

		
		while (istrue) {
			System.out.println("*****************************회원관리****************************");
			System.out.println(datestr);
			System.out.println("0:회원등록 1:회원조회 2:회원 정보 수정 3: 회원 정보 삭제, 4 종료");
			System.out.println("****************************************************************");
			menu = sc.nextInt();
			sc.nextLine();

			if (menu < commands.length) {

				commands[menu].execute(sc);

			}else {
				istrue=false;
				
			}
			
		}
		System.out.println("종료");
		System.out.println(datestr);
		
	}

}
