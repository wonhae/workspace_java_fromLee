package com.naver;

public class Monster extends Object {
//field	
	private int hp;
	
//constructor	
	public Monster() {
		// TODO Auto-generated constructor stub
	}

	public Monster(int hp) {
		super();
		this.hp = hp;
	}

// get set	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	//toString 만들어주기
	@Override
	public String toString() {
		return "Monster hp :" + hp;
	}
	
	
	
	
	
	
	
	
}
