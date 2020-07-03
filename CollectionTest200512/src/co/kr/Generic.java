package co.kr;

import java.util.ArrayList;
import java.util.List;

public class Generic {
	//Generic 설명 
	public static void main(String[] args) {
		List<StringBuffer> list = new ArrayList<StringBuffer>();
		List<Apple> appleBox = new ArrayList<Apple>();
		List<Pear> pearBox = new ArrayList<Pear>();
		// apple을 제네릭 Generic
		
		GTest<Long> gt1 = new GTest<Long>();
		GTest<Boolean> gt2 = new GTest<Boolean>();
		GTest<Byte> gt3 = new GTest<Byte>();
		GTest<Short> gt4 = new GTest<Short>();
		GTest<Float> gt5 = new GTest<Float>();
		GTest<Double> gt6 = new GTest<Double>();
		GTest<Character> gt7 = new GTest<Character>();
		GTest<Integer> gt8 = new GTest<Integer>();
		// 기본자료형도 대문자로 쓰면 자바 콜렉션 프레임워크에서 객체(랩퍼 클래스: 첫글자가 대문자.) 가 될 수 있다.  (기본자료형은 객체가 될 수 없다)
		
		
		// 기본자료형과 참조자료형은 같을 수 없다. 
		int a = new Integer(4);  //기본 자료형과 래퍼 클래스는 = 가능하다.   autounboxing때문에 가능하다. 
		System.out.println(a);  //4 라고 나옴 
		
		Integer b = 4;  //기본자료형인데 참조자료형에 할당. autoboxing 
		Integer c = new Integer(4); //원래 이렇게 해야함. 
		
		
		String str = "55";
		int d = 55;
		System.out.println(str);
		System.out.println(d);
		System.out.println(str + d); //안됨 에러. 
		
		int s = Integer.parseInt(str);  //모든 래퍼 클래스에는 래퍼클래스.parse그클래스가 있다. 중요하다. Springframework 가면 필요 없어짐. jsp sevlet에서는 중요하다. 
		System.out.println(s + d);
		
		String str2 = "C";
// x		char d = Character.parseChar(str2);
		char e = str2.charAt(0); //좀 불편하니 건의하삼 ㅋㅋ이것만 기억하기. 
		
		s = Integer.valueOf(s); 
		//value of  메소드 만 암기할 것. Integer.parseInt(str)이렇게 안써도됨. 하지만 현업에서 잘 안씀. 개발자들은 정말 원하는게 아니면 기존 것을 유지해감. 
		
		//제네릭 개념, 제네릭클래스, autoboxing,autounboxing(면접에 안나옴),  
		
		
		
		//인터페이스로 객체 만들어보기/ 익명의 내부 클래스 학습하면서 배움. 이렇게 만들면 안됨 
		
		
	}
}
