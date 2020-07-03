package com.naver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test1 {
	
	//remove
	public void me4() {
		HashSet<Integer> set4 = new HashSet<Integer>();
		set4.add(1);
		set4.add(11);
		set4.add(121);
		set4.add(111);
		set4.add(101);
		set4.add(14);
		System.out.println(set4);
		set4.remove(14);
		System.out.println(set4 + "14 제거한 후 ");
		
		set4.clear();
	}
	
	public void me3(List<Integer> list) {
		Set<Apple> set3 = new HashSet<Apple>();
		
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 3500));
		set3.add(new Apple("사과3", 2000));
		set3.add(new Apple("사과1", 3000));
		set3.add(new Apple("사과2", 1000));
		
		System.out.println(set3.size());
		System.out.println(set3);		
		
		//iteator  각가의 객체의 데이터를 교환할 수있는 중간자적 역할을 한다. 
		//이것 잘 기억하기!! 
		Iterator<Apple> it =  set3.iterator();
		ArrayList<Apple> list3 = new ArrayList<Apple>();
		
		while (it.hasNext()) {
			Apple apple = (Apple) it.next();
			System.out.print(apple.getName());
			System.out.println(apple.getPrice());
			
			list3.add(apple);
		}
		
		
// 데이터 가져오기 힘들다. set3.get ->iterator method 사용하기! 
	}
	
	public void me2(Pear p) {
		//set -> (참조자료형)동등성 비교?string은 참조자료형 (기본자료형)동일성 비교?
		Set<String> set2 = new HashSet<String>();
		set2.add("hello");
		set2.add("world");
		set2.add("hello");
		set2.add(new String("world"));
		set2.add("good");
		set2.add("morning");
		set2.add(new String("good"));
		
		System.out.println(set2.size());
		System.out.println(set2);
		
		//현업에서! iterator 사용해서 하나씩 끄집어낸다. 
		Iterator<String> it =  set2.iterator();
		while (it.hasNext())   { //str 다음에 데이터가 있냐?
			String value = (String) it.next(); 
			System.out.print(value + " ,");
		}
		System.out.println();
		
		//이렇게 해도 똑같이 나옴. 최근에 나옴. 현업에서 안씀. 
		ArrayList<String> list2 = new ArrayList<String>(set2);
		System.out.println("::::::::::::::::");
		System.out.println(list2);
		System.out.println("::::::::::::::::");
		
	}
	
	public void me1(int a) {  //int a 를 넣어야 동작을 한다! 
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(0);  //반환형은 boolean 
		set1.add(0);
		set1.add(1);
		set1.add(1);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(5);
		
		System.out.println(set1.size());
		System.out.println(set1);
		
		
		Iterator<Integer> it = set1.iterator();
		
//		while (it.hasNext()) {  //이렇게 만들어줌~ 
//			Integer integer = (Integer) it.next();
//			
//		}
		while (it.hasNext()) {
			Integer value = (Integer) it.next();
			System.out.print(value + ",");
		}
		
		
		System.out.println();
		
		
	}
}
