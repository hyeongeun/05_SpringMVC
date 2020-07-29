package com.java.fileBoard.dao;

import org.mybatis.spring.SqlSessionTemplate;

public class FileBoardDaoImp implements FileBoardDao {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public FileBoardDaoImp() {}

	public FileBoardDaoImp(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
}
