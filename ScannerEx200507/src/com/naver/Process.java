package com.naver;

import java.util.Scanner;

public class Process {
	
	public Process() {
		String str = new String("hello");
		
		System.out.println(str);
		System.out.println("::::::::::::::::::::");
		
		
		Scanner sc = new Scanner(System.in);  //System.in : keyboard  //하나 만들어서 돌려쓴다. 
		
		
		System.out.println("이름을 입력하세요."); //안내문구 필요
		String msg = sc.nextLine();  			// nextLine(); 띄어쓰기 가능: 엔터로 구별한다!  
		System.out.println(msg);
		
		
		System.out.println("::::::::::::::::::::");
		
		
		System.out.println("주소를 입력하세요."); //안내문구 필요
		msg = sc.next();  						// next 띄어쓰기 불가능 (입력해도 띄어쓰기 하기 전것만 나옴):spcebar로 구분(ㅇ
		sc.nextLine();  //반환형 없으니 날라간다 
		System.out.println(msg);
		
		
		System.out.println("::::::::::::::::::::");
		
		
		//nextline을 제외하고는 나머지는 전부 호출후  nextline 해주기! (안하면 자동입력됨...)
		System.out.println("초등학교 주소를 입력하세요");
		msg = sc.nextLine();  	//만약 위에 msg = sc.next();  만 있으면  강남구 테헤란로 78(enter) 메모리에 남아있는것 입력받음 
		System.out.println(msg);
		
		
		
		
		
		System.out.println("::::::::::::::::::::");
		
		
		System.out.println("나이를 입력하세여");
		int age = sc.nextInt();  	// 23 (enter)
		sc.nextLine();				// 반드시 호출하기 
		System.out.println(age);
		
		
		System.out.println("::::::::::::::::::::");
		System.out.println("배송지를 입력하세요");
		msg = sc.nextLine();  // enter를 만나면 입력이 끝남 
		System.out.println(msg);
		
		
		//new AAA().me1(); //익명객체   // 이렇게 쓰지말라 스캐너 객체 또 생성하고 클로즈 하고 하지말라  //에러날 가능성 
		
		new AAA().me1(sc);   //스캐너 객체는 건네주고 받고 이런식으로 사용할 것 ! 
		
		new AAA().hw(sc);
		
		sc.close(); 	//스캐너는 반드시 닫아줘야하마!! 미리 만들어두기 
	}
}
