package com.naver;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import co.kr.Apple;
import co.kr.Pear;

public class Test1 {
	
	public void me11() {
		List<Integer> list11 = new ArrayList<Integer>();
		for (int i = 0; i < 100; i ++) {
			list11.add(i);
		}
		System.out.println(list11);
		list11.clear();
		
	}
	
	public void me10() {
		List<Integer> list10 = new ArrayList<Integer>();
		for(int i =0; i <5; i ++) {
			list10.add(i * 21);
		}
		
		for(int i = list10.size()-1; i >=0; i --) {
			System.out.print(list10.get(i)+ " , ");
		
		}
//		arraylist 여기서는 데이터 수정삭제 비추
//		->수정삭제시 ★linked list(반복문--써야) 이용할 것 , Q인터페이스 사용할 것  (반드시 공부할 것) 
		
		//삭제시 뒤쪽부터 할 것 
		
		System.out.println();
		System.out.println(list10 + "[삭제전]");
		list10.remove(3);
		System.out.println(list10 + "[remover(3)삭제후]"); //삭제후 앞으로 당겨짐
		list10.remove(1);
		System.out.println(list10 + "[remover(1)삭제후]");
		
		
	}
	
	public void me9() {
		List<Long> list9 = new ArrayList<Long>();
		
		list9.add(1L);
		list9.add(34L);
		list9.add(11L);
		list9.add(44L);
		
		for( int i = 0; i < list9.size(); i ++) {
			long long1 = list9.get(i);
			System.out.println(long1);
		}
		
		boolean b = list9.contains(34L);  //()안에 new ~ 해도되고 값넣어도 되고. 오토 박싱,언박싱 
		System.out.println(b);
		//회원정보 있는지 확인?  indexOf or contains 중 하나 쓸 것 
	}
	
	public void me8() {
		List<Apple> list8 = new ArrayList<Apple>();
		list8.add(new Apple("부사", 1000));
		list8.add(new Apple("부사", 2000));
		list8.add(new Apple("홍옥", 3000));
		list8.add(new Apple("부사", 1000));
		
		int idx = list8.indexOf(new Apple("홍옥", 500));
		System.out.println(idx);
		
		int idx2 = list8.indexOf(new Apple("부사", 1000));
		System.out.println(idx);
	}
	
	public void me7() {
		List<Integer> list7 = new ArrayList<Integer>();
		
		for(int i =0; i <10; i ++) {
			list7.add(i * 2);
		}
		
		list7.set(0, 1);
		
		for(int i= list7.size()-1; i >=0; i-- ) {
			System.out.print(list7.get(i) + ",");
		}
	}
	
	
	public void me6() {
		List<Pear> list6 = new ArrayList<Pear>();
		
		Pear p1 = new Pear("배1", 3000);
		Pear p2 = new Pear("배2", 3500);
		Pear p3 = new Pear("배3", 2000);
		
		list6.add(p1);
		list6.add(p2);
		list6.add(p3);
		list6.add(new Pear("배4", 3000));
		list6.add(new Pear("배5", 1000));
		
		//stack과 oracle 빼면 모든  index 는 0부터 시작 
		Pear pp2 = list6.get(2);
		System.out.println(pp2.getName());
		System.out.println(pp2.getCost());
	
		for(int i = 0; i< list6.size(); i++) {			
			Pear p = list6.get(i);
			System.out.print(p.getName());
			System.out.println(p.getCost());
		}
		
		
	}
	
	
	//입력한 것 가져옴
	public void me5() {
		List<Apple> list5 = new ArrayList<Apple>();
		
		Apple a1 = new Apple("부사", 2000);  // new 뒤엣부분이 객체이다. 
		Apple a2 = new Apple("부사", 2500);
		Apple a3 = new Apple("알사과 ", 1000);
		
//		넣는방법 2가지 1. 객체 만들고 집어넣거나 2. 넣을때 만들거나(일반적 방법)
		list5.add(a1);
		list5.add(a2);
		list5.add(a3);
		list5.add(new Apple("부사", 3000));
		list5.add(new Apple("홍옥", 1000));
				
		//배열작업
		for(int i = 0; i < list5.size(); i++) {
			Apple aArr = list5.get(i);
			System.out.print(aArr.getName());
			System.out.println(aArr.getPrice());
		}
		
		
	}

	//list 4 객체는 1,1,2,3,4,8,11을 입력하는 기능을 가지고있다.
	public void me4() {
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(new Integer(1)); //원래는 이렇게 만들어야!! 
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(5);
		list4.add(8);
		list4.add(11);
		
		for(int i = 0; i < list4.size(); i++) {
			Integer list4I = list4.get(i);
			System.out.print(list4I + ",");
		}
		
	}
	
	
	
	
	public List<String> me3(List<String> list3) {
		list3.add("hello");
		list3.add("world");
		list3.add("good");
		list3.add("morning");
		list3.add("!!!");
		
		for(int i = 0; i < list3.size(); i++) {
			String list3Arr = list3.get(i);
			System.out.println(list3Arr);
		}
		return list3;
	}
	
	
	
	public void me2() {
		List<Apple> list2 = new ArrayList<Apple>();
		
		list2.add(new Apple("사과1", 3000));
		list2.add(new Apple("사과2", 3500));
		list2.add(new Apple("사과3", 2000));
		list2.add(new Apple("사과1", 3000));
		list2.add(new Apple("사과2", 1000));
		
		//-- 알고있어야. 나중에 remove 할 때! 
		for(int i = list2.size()-1; i >=0; i--) {
			Apple aa = list2.get(i);
			System.out.print(aa.getName() + " : ");
			System.out.println(aa.getPrice());
		}
		
		
		for(int i = 0; i < list2.size(); i++) {
			Apple a = list2.get(i);
			System.out.print(a.getName() + " : ");
			System.out.println(a.getPrice());
		}
		
	}
	
	public void me1() {
		//quiz me1()메소드는 java.util.List로 만들어진  list라는 변수명을 가지고 있다. 
		//단, 이 list엔느 3,4,5...등의 정수를 저장할 수 있다.
		//ArrayList 학습중 
		
		List<Integer> list  = new ArrayList<Integer>();
	}
	
	
	
}
