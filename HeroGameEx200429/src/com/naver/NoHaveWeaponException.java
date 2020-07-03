package com.naver;

//public class NoHaveWeaponException extends ArrayIndexOutOfBoundsException { 
//ArrayIndexOutOfBoundsException는 Runtime 익셉션의 자식 =>runtimeException 써도 됨 
public class NoHaveWeaponException extends Exception { //Exception은 컴파일예외!
 // 익셉션 처리.. 2가지 설명해주셨는데... 
	
	private static final long serialVersionId = 1L;
}
