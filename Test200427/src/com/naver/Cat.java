package com.naver;

public class Cat {
	private int id = 0;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name = null;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Cat() {
	}
	
	
	public Cat(int id, String name) {  //우클릭. 소스 - 사용자 생성자 만듦
		super();
		this.id = id;
		this.name = name;
	}

	public void run(String where) {
		System.out.println(where +"달린다");
	}
	
	public void sleep() {
		System.out.println("잔다");
	}
	
	
	
	
}
