package com.naver;

import java.util.Scanner;

public class AAA {
	
	public void me1(Scanner sc) {  //이 형태가 안정적이다. 
		
		System.out.println("주소를 입력하시오");
		String msg = sc.nextLine();
		System.out.println(msg);
		
		//sc.close(); //외부에서 넘겨받으면 함부로 닫으면안됨 
	}
	
	public void me1() {  //이렇게 쓰지 말라. 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주소를 입력하시오");
		String msg = sc.nextLine();
		System.out.println(msg);
		
		sc.close();
	}

	public void hw(Scanner sc) {
		System.out.println("신혜원을 입력하시오");
		String shw =  sc.nextLine();
		System.out.println(shw);
		
	}
}
