package com.naver;


import java.util.ArrayList;
import java.util.List;

public class DB {
	// 원래는 클래스로 만들면 안된다. 원래는 테이블로 만들어야함(JDBC)  
	// static 쓰는 이유(특징): 무조건 1개만 만들어짐, 객체 만들 필요 없음. 
	// DTO or 접미어 - VO or TO class DTO : Data Transfer Obect /TO : Transfer Object/ VO : Value Object
	// 객체 : object = instance = bean(자동으로만들어주는것 container) = entity (DB쪽에서)
	
	
	public static List<MemberDTO> db = new ArrayList<MemberDTO>();
	
	
	
	
}
