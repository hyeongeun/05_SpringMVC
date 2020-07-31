package com.java.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.member.dto.MemberDTO;
import com.java.member.dto.ZipcodeDTO;

@Component
public class MemberDaoImp implements memberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;


	@Override
	public int memberInsert(MemberDTO memberDto) {
		
		return sqlSessionTemplate.insert("member_insert",memberDto);
	}

	@Override
	public int memberIdCheck(String id) {
		
		 String value = sqlSessionTemplate.selectOne("member_id_check", id );
		 
		 int check = 0;
		 
		 if(value != null) check = 1;
		 
		return check;
	}

	@Override
	public List<ZipcodeDTO> zipcode(String dong) {
		return sqlSessionTemplate.selectList("member_zipcode",dong);
	}

	@Override
	public String logIn(String id, String password) {
		
		Map<String,String> hashMap=new HashMap<String,String>();
		hashMap.put("id",id);
		hashMap.put("password",password);
		String value = sqlSessionTemplate.selectOne("member_login",hashMap);
		
		return value;
	}

	@Override
	public int memberDeleteOk(String id, String password) {
		Map<String,String> hashMap=new HashMap<String,String>();
		hashMap.put("id",id);
		hashMap.put("password",password);
		
		int value = sqlSessionTemplate.delete("member_delete", hashMap);
		
		return value;
	}

	@Override
	public MemberDTO MemberSelect(String id) {
		
		MemberDTO memberDto = sqlSessionTemplate.selectOne("member_select", id);
		
		return memberDto;
	}

	@Override
	public int memberUpdate(MemberDTO memberDto) {
		int check = sqlSessionTemplate.update("member_update", memberDto);
		return check;
	}
}
