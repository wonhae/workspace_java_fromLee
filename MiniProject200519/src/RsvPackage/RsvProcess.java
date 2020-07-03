package RsvPackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import Total.TotalCommand;

public class RsvProcess implements TotalCommand {
	
	@Override
	public void execute(Scanner sc) {
		RsvCommand[] commands = { new RsvInsert(), new RsvSelect(), new RsvUpdate(), new RsvDelete()};

		boolean istrue = true;
		int menu = -1;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(cal.getTime());
		
		while (istrue) {
			System.out.println("***********************예매관리**********************************");
			System.out.println(datestr);
			System.out.println("0:예약입력 1: 예매 조회 2:예매 수정 3: 예매내역 삭제 4: 예매 종료");
			System.out.println("*****************************************************************");
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
