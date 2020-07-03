package MethodExplanation;

public class MainEx_para {
	private static int b =0;  //static or class 변수
	
	public static void z1(int a) {//static 쓰는 이유: 객체 안만들고 바로 접근하기 위해서 
		System.out.println(a);
	}
	
	// b=8;
	public static void w1(int b) {
		MainEx_para.b = b;
		// b=b;  처음 b는 파라미터임... 
	}
	
	
	public static void main(String[] args) {
		
		w1(8);
		
		int what = -1;
		z1(what);
	
		
	}
}
