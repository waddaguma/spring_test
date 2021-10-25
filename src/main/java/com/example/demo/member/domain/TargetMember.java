package com.example.demo.member.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="target_member")
public class TargetMember {



	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // 이 Annotation을 붙여주면 해당 변수를  PrimaryKey로 인식한다.
	private Long id;
	private String name;
	private String zipcode;
	private String email;
	private String active;
	


//	public Member(Long id, String name, String zipcode, String email, String active) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.zipcode = zipcode;
//		this.email = email;
//		this.active = active;
//	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "TRGT_MEMBER [id=" + id + ", name=" + name + ", zipcode=" + zipcode + ", email=" + email + ", active="
				+ active + "]";
	
	}


}
