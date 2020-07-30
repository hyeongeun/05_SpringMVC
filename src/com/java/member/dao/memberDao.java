package com.java.member.dao;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.java.member.dto.MemberDTO;
import com.java.member.dto.ZipcodeDTO;

public interface memberDao {

	public int memberInsert(MemberDTO memberDto);
	
	public int memberIdCheck(String id);
	
	public List<ZipcodeDTO> zipcode(String dong);

	public String logIn(String id, String password);

	public int memberDeleteOk(String id, String password);

	public MemberDTO MemberSelect(String id);

	public int memberUpdate(MemberDTO memberDto);
}
