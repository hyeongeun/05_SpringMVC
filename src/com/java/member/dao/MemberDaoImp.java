package com.java.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.member.dto.MemberDTO;
import com.java.member.dto.ZipcodeDTO;

public class MemberDaoImp implements memberDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoImp() {}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public MemberDaoImp(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

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
}
