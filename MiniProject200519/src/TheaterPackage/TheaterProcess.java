package TheaterPackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import Total.TotalCommand;

public class TheaterProcess implements TotalCommand {

	@Override
	public void execute(Scanner sc) {
		TheaterCommand[] commands = { new TheaterInsertCommand(), new TheaterSelectCommand(),
				new TheaterUpdateCommand(), new TheaterDeleteCommand() };

		int menu = -1;
		boolean isTrue = true;
		

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(cal.getTime());

		while (isTrue) {
			System.out.println("***********************영화관관리**************************************");
			System.out.println(datestr);
			System.out.println("0: 영화관 입력 , 1: 영화관 조회, 2: 영화관 수정, 3: 영화관 삭제, 4: 종료");
			System.out.println("************************************************************************");
			menu = sc.nextInt();
			sc.nextLine();

			if (menu < commands.length) {
				commands[menu].execute(sc);
			} else {
				isTrue = false;
			}
			System.out.println("영화관 입력 종료");
			System.out.println(datestr);
		}

	}

}