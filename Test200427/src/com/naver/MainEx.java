package com.naver;


import FruitClasses.Apple;
import FruitClasses.Banana;
import FruitClasses.Fruit;
import FruitClasses.FruitSeller;
import FruitClasses.Pear;
import kr.co.ca.Person;



public class MainEx {
	
	public static void main(String[] args) {

		//낯설다.....
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Cat c3 = new Cat(33333333, new String("Hello"));
		Cat[] cArr = {c1,c3};
				
		Person hong = new Person("990115-5487512", new String("홍길동"), cArr) ;
		
		//c3을 뽑아보자 private 이기 때문에 바로 접근 안된다. // 낯설다.....
		Cat[] arr= hong.getcArr();
		Cat who = arr[1];  //배열 안에서 하나를 끄집어냄
		String name =who.getName();
		System.out.println(name);
		
		System.out.println(arr[1].getName());
		 
		//실행 시 우클릭->run as ->java application
		
		
		//변수를 사용해야 하는 이유 -> 유지보수 편하게 하기 위해 
		String str = "hello";
		
		//control f 
		System.out.println(str);
		System.out.println("hi");
		System.out.println(str);
		System.out.println("hi");
		System.out.println("good");
		System.out.println("hi");
		System.out.println("hello1");
		System.out.println("hi");
		
		
		Fruit[] fArr = {new Apple(), new Banana(), new Apple() ,new Pear()};
		Fruit a = fArr[0];
		FruitSeller jangsu = new FruitSeller(fArr);
		
		
		
		
	}
	
	
	

}
