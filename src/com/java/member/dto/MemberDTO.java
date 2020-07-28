package com.java.member.dto;

import java.util.Date;

public class MemberDTO { // Data Transfer Object
	
	private String id;
	private String password;
	private String name;
	private String jumin1;
	private String jumin2;
	private String email;
	private String zipcode;
	private String address;
	private String job;
	private String mailing;
	private String interest;
	
	private Date registerDate;		// 자바에서는 Date 클래스 사용, SQL에서는 SYSDATE 사용
	private int number;				// SQL에서 시퀀스 처리. (.nextval)
	private String memberLevel;		// 회원등급 : 3개(BA, AA, VIP)
	
	// 계정 생성, 테이블, 시퀀스 생성
	
	public MemberDTO(String id, String password, String name, String jumin1, String jumin2, String email,
			String zipcode, String address, String job, String mailing, String interest, Date registerDate, int number,
			String memberLevel) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		
		this.email = email;
		this.zipcode = zipcode;
		this.address = address;
		this.job = job;
		this.mailing = mailing;
		
		this.interest = interest;
		this.registerDate = registerDate;
		this.number = number;
		this.memberLevel = memberLevel;
	}

	public MemberDTO() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin1() {
		return jumin1;
	}

	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}

	public String getJumin2() {
		return jumin2;
	}

	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMailing() {
		return mailing;
	}

	public void setMailing(String mailing) {
		this.mailing = mailing;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", jumin1=" + jumin1 + ", jumin2="
				+ jumin2 + ", email=" + email + ", zipcode=" + zipcode + ", address=" + address + ", job=" + job
				+ ", mailing=" + mailing + ", interest=" + interest + ", registerDate=" + registerDate + ", number="
				+ number + ", memberLevel=" + memberLevel + "]";
	}
	

}
