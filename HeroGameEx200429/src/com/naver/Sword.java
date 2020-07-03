package com.naver;

public class Sword extends Weapon { // 추상클래스 구현해야

	public Sword() {
		//super("활", 1); //사용자 부모 생성자 사용 
	}
	
	public Sword(String name, int attackPower) {
		super(name, attackPower);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void describe() {
		System.out.println("칼로 마구 찌릅니다. ");
		
	}
	
	@Override
	public String toString() {		//각각의 자식클래스에서 오버라이딩 할 필요는 없었음 
		return super.getName();  
		//그냥 getName 해도됨. 부모가 가진 자원은(변수,상수,메소드 -생성자는제외) 자식이 마음대로 사용가능 
	}

	
}
