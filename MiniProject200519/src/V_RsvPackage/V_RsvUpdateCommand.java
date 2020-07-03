package V_RsvPackage;

import java.util.Scanner;

public class V_RsvUpdateCommand implements V_RsvCommand {
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		System.out.println("수정할 고객의아이디를입력하세요");
		String customerId = sc.nextLine();

		System.out.println("수정할 고객의이름을 선택하세요");
		String customerName = sc.nextLine();

		System.out.println("수정할 영화아이디 입력");
		String movieId = sc.nextLine();

		System.out.println("수정할 영화제목 입력");
		String movieTitle = sc.nextLine();

		System.out.println("수정할 영화관아이디 입력");
		String theaterId = sc.nextLine();

		System.out.println("수정할 영화관이름 입력");
		String theaterName = sc.nextLine();

		System.out.println("수정할 예매번호 입력");
		String rsvId = sc.nextLine();

		System.out.println("수정할 예매이름 입력");
		String rsvName = sc.nextLine();
		System.out.println("수절한 예매한날짜 입력");
		String rsvDay = sc.nextLine();
		System.out.println("수정할 예매한시간 입력");
		String rsvTime = sc.nextLine();
		System.out.println("수정할 예매번호 입력");
		int rsvNum = sc.nextInt();
		sc.nextLine();
		System.out.println("결제방법 입력");
		String rsvPaymentMethod = sc.nextLine();
		System.out.println("총금액 입력");
		int rsvTotal = sc.nextInt();
		sc.nextLine();
		
		V_RsvDTO dto =new V_RsvDTO(customerId, customerName, movieId, movieTitle, theaterId, theaterName, rsvId, rsvDay, rsvTime, rsvNum, rsvPaymentMethod, rsvTotal);
		V_RsvDAO dao = new V_RsvDAO();
		dao.update(dto);

	}
}
