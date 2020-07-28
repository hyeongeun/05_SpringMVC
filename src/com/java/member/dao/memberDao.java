package com.java.member.dao;

import com.java.member.dto.MemberDTO;

public interface memberDao {

	public int memberInsert(MemberDTO memberDto);
	
	public int memberIdCheck(String id);
}
