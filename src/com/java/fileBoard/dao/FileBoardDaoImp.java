package com.java.fileBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.fileBoard.dto.FileBoardDTO;

public class FileBoardDaoImp implements FileBoardDao {

	private SqlSessionTemplate sqlSessionTemplate;

	public FileBoardDaoImp() {}

	public FileBoardDaoImp(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int fileBoardGroupNumberMax() {
		return sqlSessionTemplate.selectOne("board_group_number_max");
	}

	@Override
	public int fileBoardWriteNumber(HashMap<String, Integer> hMap) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("board_sequence_update",hMap);
	}

	@Override
	public int fileBoardWrite(FileBoardDTO fileBoardDto) {
		if(fileBoardDto.getFileName()==null) {
			return sqlSessionTemplate.insert("board_insert",fileBoardDto);
		}
		return sqlSessionTemplate.insert("file_board_insert",fileBoardDto);
	}

	@Override
	public int fileBoardCount() {
		return sqlSessionTemplate.selectOne("board_count");
	}

	@Override
	public List<FileBoardDTO> fileBoardList(int startRow, int endRow) {

		Map<String,Integer> hashMap=new HashMap<String,Integer>();
		hashMap.put("startRow",startRow);
		hashMap.put("endRow",endRow);
		sqlSessionTemplate.selectList("board_list",hashMap);
		return sqlSessionTemplate.selectList("board_list",hashMap);

	}

	@Override
	public FileBoardDTO fileBoardRead(int boardNumber) {
		sqlSessionTemplate.update("board_read_count_update",boardNumber);
		
		return sqlSessionTemplate.selectOne("board_read",boardNumber);
	}

	@Override
	public FileBoardDTO fileBoardSelect(int boardNumber) {
		return sqlSessionTemplate.selectOne("board_read",boardNumber);
	}
}


























