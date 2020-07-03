package V_RsvPackage;

import java.util.Scanner;

public class V_RsvDeleteCommand implements V_RsvCommand {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		System.out.println("수정할 영화아이디");
		String rsvId = sc.nextLine();

		V_RsvDAO dao = new V_RsvDAO();
		dao.delect(rsvId);

	}
}
