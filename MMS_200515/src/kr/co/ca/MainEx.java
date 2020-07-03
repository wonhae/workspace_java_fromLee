package kr.co.ca;

import com.naver.AccountDAO;
import com.naver.Process;

public class MainEx {
	public static void main(String[] args) {
		
		AccountDAO dao = new AccountDAO();
		dao.transfer("b", "a", 1000);  //실행,종료후 test100.sql 가서 select 해서 확인
		
		
		new Process();
		
		
	}
}
