package MethodExplanation;

public class MainEx {  //method 실행순서 
	
	public static void k3() {
		System.out.println("a");
		System.out.println("b");
	}
	
	public static void me1() { //메소드 실행 끝나면 호출했던 곳으로 다시감~ 
		System.out.println("hello");
		k3(); //ctrl click ->해당 메소드로 이동 
		System.out.println("good");
	}
	
	public static void main(String[] args) {
		//main method 는 프로젝트에 1개만 있다. 무조건 메인메소드부터 실행!! 
		System.out.println(1);
		System.out.println(2);
		me1();
		System.out.println(3);
		System.out.println(4);
	}
}
