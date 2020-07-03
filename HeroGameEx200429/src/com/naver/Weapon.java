package com.naver;

public abstract class Weapon {
//field	
	private String name = "bow";	
	private int attackPower = 1;
	
//constructor	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}
	//사용자 constructor	
	public Weapon(String name, int attackPower) {
		super(); //실행되면 객체가 생성됨 / bow 실행시 weapon만들어짐. homeplus 예외 
		this.name = name;
		this.attackPower = attackPower;
	}


//method
	public void attack(Monster m) { //누구 공격할지 대상이 바뀜. 외부에서! ->파라미터  //공격에 삑사리고려? 랜덤클래스로~
		
		describe();  // ctrl 1     // 뭘로 공격해? 바뀜 -> 자식클래스에서 무조건 오버라이드 하게 만드려면 추상메소드... 
		
		int cHp = m.getHp();
		int rHp = cHp - attackPower;
		m.setHp(rHp);
		System.out.println("몬스터를 공격하였습니다.");
		System.out.println(m + "...남은 몬스터 hp ========몬스터 파라 출력========");		
	}
	

	public abstract void describe();  //추상메소드 실행할게 없으니 Bow로 감!   // 추상메소드 가지고 있으면 추상 클래스로 바꿔줘야함
	
	@Override //안써도됨.. 겟셋으로해결가능
	public String toString() {
		return name;
	}

	
//getset	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	
	

}
