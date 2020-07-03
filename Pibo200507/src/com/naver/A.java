package com.naver;

public class A {
	
	public void me1() {
		long[] arr = new long[30];
		arr[0] = 1;
		arr[1] = 1;
		for(int i =2; i <arr.length; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		for(long shin : arr) {
			System.out.println(shin);
		}
	}
}
