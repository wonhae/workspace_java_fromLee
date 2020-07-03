package MoviePackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import Total.TotalCommand;

public class MovieProcess implements TotalCommand {

	@Override
	public void execute(Scanner sc) {
		MovieCommand[] commands = { new MovieInsertCommand(), new MovieSelectCommand(), new MovieUpdateCommand(),
				new MovieDeleteCommand()

		};
		boolean isTrue = true;
		int menu = -1;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(cal.getTime());

		while (isTrue) {
			System.out.println("************************영화관리************************************");
			System.out.println(datestr);
			System.out.println("0 영화입력, 1 영화내역 조회, 2 영화 내역 수정 , 3 영화 삭제, 4 종료");
			System.out.println("*******************************************************************");
			menu = sc.nextInt();
			sc.nextLine();
			if (menu < commands.length) {
				commands[menu].execute(sc);
			} else {
				isTrue = false;
			}

		}
		System.out.println("영화관리 종료");
		System.out.println(datestr);
	}
}
