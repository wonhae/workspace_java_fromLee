package com.naver;

public class Test {
	
	public void me2() {  //배열로 작업. 필요할 때 사용가능해서 더 좋다. 
		long[] arr = new long[100];  //알고리즘과 반복문 사용할때 사용하는 배열
		arr[0] = 1;
		arr[1] = 1;
		
		//내가한 코드 잘 실행됨! 
//		for(int i = 0; i<98; i++) {
//			arr[i+2] = arr[i] + arr[i+1];
//			System.out.println(arr[i]);
//		}
		
		//샘 코드 
		for(int i = 2; i < arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}		
		for(long x : arr) {
			System.out.println(x);
		}
		
	}
	
	public void me1() {
		//피보나치 수 100개 출력 
		//1, 1, 2, 3, 5, 8, 
		int pp = 1;
		int p1 = 1;
		System.out.println(pp);
		System.out.println(p1);
		
		int cur = -1;
		
		for(int i = 0; i <98 ; i++) {
			cur = pp + p1;
			System.out.println(cur);
			
			pp = p1; //전값이 전전값이 되고,
			p1 = cur;  //, 현재값이 전값이 된다. 
		}
		
	}
}
