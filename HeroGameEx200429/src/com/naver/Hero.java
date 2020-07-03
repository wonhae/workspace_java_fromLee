package com.naver;

public class Hero {

//field	
	private Weapon[] weapons;  //weapon 클래스는 배열에 몽땅 집어넣을 수 있다! 
	private Weapon hasWeapon; //Hero는 3개의 무기중에서 하나를 손에 들고(구성요소=변수)
	
//constructor	
	public Hero() { //손으로 든게 있어야함.  // 디비로 못받올 경우 여기에 넣는경우 있다. 보통은 디폴트 생성자는 비움 
		weapons = new Weapon[] {new Bow("활",1), new Sword("검", 5), new Hammer("망치", 10)};
		
		// x  this.hasWeapon = new Bow("활", 1);  //무기가 4개가됨
		
		hasWeapon = weapons[0];  // 활을 들고있게 하라 . 하나에 대해 2개의 리모콘 
	}

	public Hero(Weapon[] weapons, int idx) { // 손에 들고있는 무기를 index 통해  확인할 수 있게끔. 
		super();
		this.weapons = weapons;
		this.hasWeapon = weapons[idx];
	}
	
//method
	public void attack(Monster m) { //손에 들고있는 무기로 몬스터를 때림
		hasWeapon.attack(m);
	}
	
	//어떤무기로 교체할지?
	public void changeWeapon(int idx) throws NoHaveWeaponException {  //NoHaveWeaponException대신 Exception넣어도됨. 다형성 
		
//		//예외는 안뜨지만 좋지 않은 코드 
//		if(idx >= weapons.length) { // idx >= weapons.length or idx > weapons.length-1
//			idx = weapons.length-1;  //예외 발생 시킬 것!! 
//		}

		if(idx >= weapons.length) {
			throw new NoHaveWeaponException();  //컴파일 익셉셥이 더 좋다.
			//throw new ArrayIndexOutOfBoundsException();  //눈치없는 예외. 장례식장에서 인사 비유
			//런타임익셉션 //문법상 이상은 없는데 실행하면서 발생하는 예외 ->throws 안해도됨.
		}  
			
		
		hasWeapon = weapons[idx];
		System.out.println(hasWeapon);  //현재 어떤무기 들고있는가?
	}
	
	
	
	
	
	
	
	
	
}
