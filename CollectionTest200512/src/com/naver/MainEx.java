package com.naver;

import java.util.ArrayList;
import java.util.List;

public class MainEx {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.me6();
		
		//이것도됨 new Test1().me6();
		
		t1.me5();
		
		new Test1().me4();
		
		
		System.out.println();
		System.out.println("==========list3============");
		List<String> list3 = new ArrayList<String>();
		t1.me3(list3);
		
		t1
		.me2();
		
		t1.me7();
		
		t1.me8();
		
		t1.me9();
		
		t1.me10();
		
		t1.me11();
		
		
	}
}
