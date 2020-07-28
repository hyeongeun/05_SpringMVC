package com.java.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.member.dto.MemberDTO;

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
}
