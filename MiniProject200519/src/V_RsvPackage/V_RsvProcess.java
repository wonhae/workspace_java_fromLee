package V_RsvPackage;

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class V_RsvProcess {
	public V_RsvProcess() {
		// TODO Auto-generated constructor stub

		V_RsvCommand[] command = { new V_RsvInsertCommand(), new V_RsvSelectCommand(), new V_RsvUpdateCommand(),
				new V_RsvDeleteCommand() };

		boolean istrue = true;
		int menu = -1;
		Scanner sc = new Scanner(System.in);
		
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr = sdf.format(cal.getTime());
		

		while (istrue) {
			System.out.println("*************영화 예매 관리 프로그램***************");
			System.out.println(datestr);
			System.out.println(" ");
			System.out.println("***************************************************");

			if (menu < command.length) {
				command[menu].execute(sc);

			} else {
				istrue = false;

			}
			
			System.out.println("이제그만해");
			System.out.println(datestr);

		}
		sc.close();
	}

}
