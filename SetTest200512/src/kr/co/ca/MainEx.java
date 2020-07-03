package kr.co.ca;

import java.util.ArrayList;
import java.util.List;

import com.naver.Apple;
import com.naver.Pear;
import com.naver.Test1;

public class MainEx {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		
		t1.me1(10);  //아무거나 넣어도됨 ! 상관없음 //결과 5개나옴 .
		
		Pear p1 = new Pear();
		t1.me2(new Pear()); //world hello good morning
		
		List<Integer> liIn = new ArrayList<Integer>();
		t1.me3(liIn); //4
		
		t1.me4();
	}
}

