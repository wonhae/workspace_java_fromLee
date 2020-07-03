package com.naver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {

	public void me5() {
		Map<String, Apple> map5 = new HashMap<String, Apple>();

		map5.put("부사", new Apple("부사", 2000));
		map5.put("대구", new Apple("홍옥", 3000));
		map5.put("대전", new Apple("왕사과", 4000));
		map5.put("서울", new Apple("부사", 1000));

		Set<String> set = map5.keySet();
		Iterator<String> it = set.iterator();
//		while문 빠져나가고 싶으면 변수선언할 것   ////
		while (it.hasNext()) {
			String key = it.next();
			Apple value = map5.get(key);
			System.out.print(value.getName());
			System.out.println(value.getPrice());
		}

	}

	public void me4() {
		Map<String, Integer> map4 = new HashMap<String, Integer>();
		map4.put("hello", 1);
		map4.put("world", 2);
		map4.put("good", 3);
		map4.put("morning", 4);

		int a = map4.get("hello"); // autounboxing
		System.out.println(a);
		int b = map4.get("world");
		System.out.println(b);

		Set<String> set = map4.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String value = (String) it.next();
			System.out.print(value + ",");
		}
		System.out.println();

	}

	public void me3() {
		Map<Integer, String> map3 = new HashMap<Integer, String>();
		map3.put(1, "hello");
		map3.put(101, "hello");
		map3.put(1, "world"); // 값이 hello -> world로 바뀌었다고 생각함!
		map3.put(2, "!!!!!");

		System.out.println(map3); // map은 중괄호 ( list, set -> 대괄호)

		Set<Integer> set = map3.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer value = (Integer) it.next();
			System.out.print(value + ",");
		}
		System.out.println();

	}

	public void me2() {
		Map<Pear, Apple> map2 = new HashMap<Pear, Apple>();
	}

	public void me1() {
		Map<String, String> map1 = new HashMap<String, String>();

	}

}
