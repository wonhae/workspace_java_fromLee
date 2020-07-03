package kr.co.ca;

import java.util.Scanner;

public interface Command {
	void execute (Scanner sc);
	
	//인터페이스에 추상메소드가 1개만 들어가는것 ->functional interface
}
