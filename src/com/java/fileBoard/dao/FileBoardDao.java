package com.java.fileBoard.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.java.fileBoard.dto.FileBoardDTO;

public interface FileBoardDao {
	
	public int fileBoardGroupNumberMax();
	
	public int fileBoardWriteNumber(HashMap<String, Integer> hMap);
	
	public int fileBoardWrite(FileBoardDTO fileBoardDto);

	public int fileBoardCount();
	
	public List<FileBoardDTO> fileBoardList(int startRow, int endRow);

	public FileBoardDTO fileBoardRead(int boardNumber);

	public FileBoardDTO fileBoardSelect(int boardNumber);
	public int fileBoardDelete(String password, int boardNumber);

}
