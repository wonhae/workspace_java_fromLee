package com.naver;

import java.io.Serializable;

public class MemberDTO implements Serializable {  //DTO 클래스에는 별도의 메소드는 거의 안들어감 
	
	private static final long serialVersionUID = 1L;
	// 1.
	private String id;
	private String name;
	private int age;
	
	//2. 생성자2개
	public MemberDTO() {}

	public MemberDTO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	//3. getters setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//4. equals, hashcode -> id만선택  (만약 id, name, age 다 선택할 경우 update 가서 name, age 만들어주기) 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	// 5. tostring
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " : " + name; // m001 : kim
	}
	
	
	
	
	
	
	
	
	
	
}
