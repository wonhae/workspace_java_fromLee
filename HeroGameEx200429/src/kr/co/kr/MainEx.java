package kr.co.kr;

import com.naver.Bow;
import com.naver.Hammer;
import com.naver.Hero;
import com.naver.Monster;
import com.naver.NoHaveWeaponException;
import com.naver.Sword;
import com.naver.Weapon;


public class MainEx {
	public static void main(String[] args) {
		
		Monster m = new Monster(10);
	
		System.out.println(m);
		
		Weapon[] weapons = {new Bow("활", 1), new Sword("검", 5), new Hammer("망치", 10), new Bow()};  //보통은db에서 가져옴
		int hasWeaponIdx = 0;
		
		Hero superman = new Hero(); //test  정적으로~ 
		
		Hero spyderman = new Hero(weapons, hasWeaponIdx);
		
		spyderman.attack(m); // 실행 시 바로 보우로 감 
		spyderman.attack(m);
		
		try {
			spyderman.changeWeapon(1);
		} catch (NoHaveWeaponException e1) {
			System.out.println("무기변경에 실패했습니다.");
			e1.printStackTrace();
		} //검 으로 무기 교체됨	
		
		
		spyderman.attack(m);
		
		
		
		try {
			spyderman.changeWeapon(100);
		} catch (NoHaveWeaponException e) {
			System.out.println("무기변경에 실패했습니다.");
			e.printStackTrace();
		}
		
		//원래는 메인메소드에서 무한반복문 돌려야함~~ 
		
		
		// 디폴트 생성자이므로 만들 때에도 디폴트 생성자에 만들 것이다.
		// 객체를 만들면 그 객체 내부의 디폴트 생성자가 실행되고, 그 안의 내용들이 실행된다.
				
		
		new Process();
		
	}
}
