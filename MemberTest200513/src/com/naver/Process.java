package com.naver;

import java.util.Scanner;

import a.InsertCommand;
import b.SelectCommand;
import c.UpdateCommand;
import d.DeleteCommand;
import kr.co.ca.Command;

public class Process {
	
	public Process() { //여기에 때려박기 (메인메소드에 할 것 여기에 다 넣기 ) 여기다 조합하기~ 
		
		Command[] command = {new InsertCommand(),  //command 인터페이스 구현한 이유!! 2-1
							new SelectCommand(),
							new UpdateCommand(), 
							new DeleteCommand()
							};
		
		boolean isTrue = true;
		int menu = -1;
		
		Scanner sc = new Scanner(System.in);
		
		while(isTrue) {
			System.out.println("메뉴를 선택하시오.");
			System.out.println("0: 입력, 1: 조회, 2: 수정, 3: 삭제 , 4: 종료 ");  //원래 여기도 반복문 이용해서 출력해야함. 더 추가될 수있으니. 종료는 command의 크기! 
			
			menu = sc.nextInt();
			sc.nextLine();
			
			if(menu < command.length) {
				command[menu].execute(sc);  //command 인터페이스 구현한 이유!! 2-2
				
				// 만약 command 구현안했으면   if new Insertcommand().execute(sc); else~~ 해야했다. 			
			} else {
				isTrue = false;
			}
		
		}
		
		System.out.println("시스템 종료");
		sc.close();
		
		
		
	}
}
